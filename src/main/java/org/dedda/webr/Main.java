package org.dedda.webr;

import org.dedda.bratwurst.lang.*;
import org.dedda.bratwurst.parse.Parser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * Created by dedda on 9/25/15.
 *
 * @author dedda
 */
public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Config config = Config.load(new File("routes.json"));
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

}
