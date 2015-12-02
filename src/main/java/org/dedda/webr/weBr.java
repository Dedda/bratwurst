package org.dedda.webr;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import org.dedda.bratwurst.lang.BWInteger;
import org.dedda.bratwurst.lang.BWVariable;
import org.dedda.bratwurst.lang.Program;
import org.dedda.bratwurst.parse.Parser;

import java.io.*;
import java.net.InetSocketAddress;
import java.util.HashMap;

/**
 * Created by dedda on 12/2/15.
 *
 * @author dedda
 */
public class weBr implements HttpHandler {

    private HashMap<String, String> routesMap;
    private HttpServer server;

    public weBr(int port) throws IOException {
        routesMap = new HashMap<>();
        server = HttpServer.create(new InetSocketAddress(port), 0);
        server.createContext("/", this);
        server.setExecutor(null);
        server.start();
    }

    public boolean addRoute(String route, String script) {
        if (routesMap.containsKey(route)) {
            return false;
        }
        routesMap.put(route, script);
        return true;
    }

    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        System.out.println(1);
        String route = httpExchange.getRequestURI().toString().split("\\?")[0];
        System.out.println(2);
        String attributesS[] = httpExchange.getRequestURI().toString().split("\\?")[1].split("&");
        System.out.println(3);
        HashMap<String, Integer> params = new HashMap<>();
        System.out.println(4);
        for (String attribute : attributesS) {
            params.put(attribute.split("=")[0], Integer.parseInt(attribute.split("=")[1]));
        }
        System.out.println(5);
        String rendered = call(route, params);
        System.out.println(6);
        System.out.println(rendered);
        httpExchange.getResponseHeaders().set("Content-Type", "text/html");
        httpExchange.sendResponseHeaders(200, rendered.length());
        httpExchange.getResponseBody().write(rendered.getBytes());
        httpExchange.getRequestBody().close();
    }

    public String call(String route, HashMap<String, Integer> parameters) throws UnsupportedEncodingException {
        if (!routesMap.containsKey(route)) {
            return "No route to " + route;
        }
        String filename = routesMap.get(route);
        File file = new File(filename);
        if (!file.exists()) {
            throw new RuntimeException("script " + file + " not found!");
        }
        Parser parser = new Parser(file);
        parser.parse();
        for (String key : parameters.keySet()) {
            Program.getInstance().registerVariable(
                    new BWVariable(key, new BWInteger(parameters.get(key)))
            );
        }
        PrintStream origOut = System.out;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        System.setOut(ps);
        Program.getInstance().run();
        String content = baos.toString("utf-8");
        System.setOut(origOut);
        return content;
    }
}
