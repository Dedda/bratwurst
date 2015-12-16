package org.dedda.webr;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by dedda on 12/3/15.
 *
 * @author dedda
 */
public class Config {

    private int port;

    private List<Route> dynamicRoutes;

    private List<Route> staticRoutes;

    private Map<String, List<String>> contentTypes;

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public List<Route> getDynamicRoutes() {
        return dynamicRoutes;
    }

    public void setDynamicRoutes(List<Route> dynamicRoutes) {
        this.dynamicRoutes = dynamicRoutes;
    }

    public List<Route> getStaticRoutes() {
        return staticRoutes;
    }

    public void setStaticRoutes(List<Route> staticRoutes) {
        this.staticRoutes = staticRoutes;
    }

    public Map<String, List<String>> getContentTypes() {
        return contentTypes;
    }

    public void setContentTypes(Map<String, List<String>> contentTypes) {
        this.contentTypes = contentTypes;
    }

    public static Config load(File file) throws FileNotFoundException {
        Gson gson = new Gson();
        return gson.fromJson(new FileReader(file), Config.class);
    }



}
