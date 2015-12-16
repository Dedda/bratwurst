package org.dedda.webr;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by dedda on 9/25/15.
 *
 * @author dedda
 */
public class Main {

    private static Config config;

    public static void main(String[] args) throws FileNotFoundException {
        config = Config.load(new File("routes.json"));
        weBr weBr = null;
        try {
            weBr = new weBr(config.getPort());
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (Route route : config.getDynamicRoutes()) {
            weBr.addDynamicRoute(route);
        }
        for (Route route : config.getStaticRoutes()) {
            weBr.addStaticRoute(route);
        }
    }

    public static Config getConfig() {
        return config;
    }

}
