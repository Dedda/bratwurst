package org.dedda.webr;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import org.dedda.bratwurst.lang.BWInteger;
import org.dedda.bratwurst.lang.BWVariable;
import org.dedda.bratwurst.lang.Program;
import org.dedda.bratwurst.parse.Parser;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.util.HashMap;

/**
 * Created by dedda on 12/2/15.
 *
 * @author dedda
 */
public class weBr implements HttpHandler {

    private HashMap<String, weBrRoute> dynamicRoutes;
    private HashMap<String, weBrRoute> staticRoutes;
    private HttpServer server;

    public weBr(int port) throws IOException {
        dynamicRoutes = new HashMap<>();
        staticRoutes = new HashMap<>();
        server = HttpServer.create(new InetSocketAddress(port), 0);
        server.createContext("/", this);
        server.setExecutor(null);
        server.start();
    }

    public boolean addDynamicRoute(Route route) {
        if (dynamicRoutes.containsKey(route.getRoute())) {
            return false;
        }
        if (staticRoutes.containsKey(route.getRoute())) {
            return false;
        }
        weBrRoute weBrRoute = new weBrRoute();
        weBrRoute.dir = new File(route.getEndpoint()).isDirectory();
        weBrRoute.endpoint = route.getEndpoint();
        weBrRoute.route = route.getRoute();
        dynamicRoutes.put(route.getRoute(), weBrRoute);
        return true;
    }

    public boolean addStaticRoute(Route route) {
        if (staticRoutes.containsKey(route.getRoute())) {
            return false;
        }
        if (dynamicRoutes.containsKey(route.getRoute())) {
            return false;
        }
        weBrRoute weBrRoute = new weBrRoute();
        weBrRoute.dir = new File(route.getEndpoint()).isDirectory();
        weBrRoute.endpoint = route.getEndpoint();
        weBrRoute.route = route.getRoute();
        staticRoutes.put(route.getRoute(), weBrRoute);
        return true;
    }

    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        System.out.println("request: " + httpExchange.getRequestURI());
        HashMap<String, Integer> params = new HashMap<>();
        String route;
        if (httpExchange.getRequestURI().toString().contains("?")) {
            route = httpExchange.getRequestURI().toString().split("\\?")[0];
            String attributesS[] = httpExchange.getRequestURI().toString().split("\\?")[1].split("&");
            for (String attribute : attributesS) {
                params.put(attribute.split("=")[0], Integer.parseInt(attribute.split("=")[1]));
            }
        } else {
            route = httpExchange.getRequestURI().toString();
        }
        String rendered = call(route, params);
        System.out.println("rendered page: " + rendered);
        httpExchange.getResponseHeaders().set("Content-Type", "text/html");
        httpExchange.sendResponseHeaders(200, rendered.length());
        httpExchange.getResponseBody().write(rendered.getBytes());
        httpExchange.getRequestBody().close();
    }

    public String call(String requestRoute, HashMap<String, Integer> parameters) throws UnsupportedEncodingException {
        for (String key : staticRoutes.keySet()) {
            if (requestRoute.startsWith(key)) {
                weBrRoute buffer = staticRoutes.get(key);
                String filename;
                if (buffer.dir || requestRoute.equals(buffer.route)) {
                    filename = requestRoute;
                    if (filename.startsWith("/")) {
                        filename = filename.substring(1);
                    }
                    return callStatic(filename);
                }
            }
        }
        weBrRoute weBrRoute = null;
        for (String key : dynamicRoutes.keySet()) {
            if (key.startsWith(requestRoute)) {
                weBrRoute = dynamicRoutes.get(key);
                break;
            }
        }
        if (weBrRoute == null) {
            return "No route found! #1";
        }
        String filename = weBrRoute.endpoint;
        if (weBrRoute.dir) {
            filename = weBrRoute.endpoint + requestRoute.replaceFirst("^" + weBrRoute.route, "/");
        } else if (!weBrRoute.route.equals(requestRoute)) {
            return "no route found! #2";
        }
        File file = new File(filename);
        if (!file.exists()) {
            throw new RuntimeException("script " + file + " not found!");
        }
        Parser parser = new Parser(file);
        Program program = parser.parse();
        for (String key : parameters.keySet()) {
            program.registerVariable(
                    new BWVariable(key, new BWInteger(parameters.get(key)))
            );
        }
        PrintStream origOut = System.out;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        System.setOut(ps);
        program.run();
        String content = baos.toString("utf-8");
        System.setOut(origOut);
        return content;
    }

    private String callStatic(String file) {
        String contents = "";
        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File(file)));
            String buffer;
            while ((buffer = reader.readLine()) != null) {
                contents += buffer;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contents;
    }

    private class weBrRoute {

        private String route;

        private String endpoint;

        private boolean dir;

    }

}
