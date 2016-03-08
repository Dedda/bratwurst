package org.dedda.webr;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import org.dedda.bratwurst.lang.BWInteger;
import org.dedda.bratwurst.lang.BWString;
import org.dedda.bratwurst.lang.BWVariable;
import org.dedda.bratwurst.lang.Program;
import org.dedda.bratwurst.parse.Parser;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static java.util.concurrent.Executors.newCachedThreadPool;

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
        server.setExecutor(newCachedThreadPool());
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
        List<BWVariable> params = new ArrayList<>();
        String route;
        if (httpExchange.getRequestURI().toString().contains("?")) {
            route = httpExchange.getRequestURI().getPath();
            String attributresS[] = httpExchange.getRequestURI().getQuery().split("&");
            for (String attr : attributresS) {
                String name = attr.split("=")[0];
                String value = attr.split("=")[1];
                if (value.matches("\\-?\\d+")) {
                    params.add(new BWVariable(name, new BWInteger(Integer.parseInt(value))));
                } else {
                    params.add(new BWVariable(name, new BWString(value)));
                }
            }
        } else {
            route = httpExchange.getRequestURI().toString();
        }
        Response rendered = call(route, params);
        System.out.println("rendered page: " + rendered);
        String filetype = rendered.getFiletype();
        httpExchange.getResponseHeaders().set("Content-Type", filetype);
        httpExchange.sendResponseHeaders(rendered.getCode(), rendered.getContent().length);
        httpExchange.getResponseBody().write(rendered.getContent());
        httpExchange.getRequestBody().close();
    }

    public Response call(String requestRoute, List<BWVariable> parameters) throws UnsupportedEncodingException {
        Response response = new Response();
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
            response.setContent("No route found! #1".getBytes());
            response.setCode(404);
            response.setFiletype("text/html");
            return response;
        }
        String filename = weBrRoute.endpoint;
        if (weBrRoute.dir) {
            filename = weBrRoute.endpoint + requestRoute.replaceFirst("^" + weBrRoute.route, "/");
        } else if (!weBrRoute.route.equals(requestRoute)) {
            response.setContent("No route found! #2".getBytes());
            response.setCode(404);
            response.setFiletype("text/html");
            return response;
        }
        File file = new File(filename);
        if (!file.exists()) {
            throw new RuntimeException("script " + file + " not found!");
        }
        Parser parser = new Parser(file);
        Program program = parser.parse();
        for (BWVariable param : parameters) {
            program.registerVariable(param);
        }
        PrintStream origOut = System.out;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        System.setOut(ps);
        program.run();
        String content = baos.toString("utf-8");
        System.setOut(origOut);
        response.setContent(content.getBytes());
        response.setFiletype("text/html");
        return response;
    }

    public void stop() {
        this.server.stop(0);
    }

    protected Response callStatic(String file) {
        byte contents[] = new byte[(int) new File(file).length()];
        try {
            new FileInputStream(file).read(contents);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Response response = new Response();
        response.setContent(contents);
        response.setFiletype(getContentType(file.substring(file.lastIndexOf("."))));
        return response;
    }

    private String getContentType(String filetype) {
        for (String key : Main.getConfig().getContentTypes().keySet()) {
            if (Main.getConfig().getContentTypes().get(key).contains(filetype)) {
                return key;
            }
        }
        return "text/html";
    }

    private class weBrRoute {

        private String route;

        private String endpoint;

        private boolean dir;

    }

}
