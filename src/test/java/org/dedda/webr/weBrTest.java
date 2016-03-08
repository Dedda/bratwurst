package org.dedda.webr;

import org.dedda.bratwurst.FileSystemTestCase;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;
import static org.testng.Assert.assertNotEquals;

/**
 * Created by dedda on 3/7/16.
 *
 * @author dedda
 */
public class weBrTest extends FileSystemTestCase {

    @Test
    public void testCallStatic() throws Exception {
        weBr weBrInstance = new weBr(10000);
        Config config = new Config();
        Map<String, List<String>> contentTypes = new HashMap<>();
        List<String> css = new ArrayList<>(1);
        css.add("css");
        contentTypes.put("text/css", css);
        config.setContentTypes(contentTypes);
        List<Route> staticRoutes = new ArrayList<>(1);
        Route staticRoute = new Route();
        staticRoute.setRoute("/static");
        staticRoute.setEndpoint("static");
        staticRoutes.add(staticRoute);
        Main.setConfig(config);
        weBrInstance.addStaticRoute(staticRoute);
        System.out.println(weBrInstance.callStatic("static/css/bootstrap.min.css"));
        String actual = new String(weBrInstance.callStatic("static/css/bootstrap.min.css").getContent());
        assertContentEquals(new File("static/css/bootstrap.min.css"), actual);
        actual = new String(weBrInstance.call("/static/css/bootstrap.css", new ArrayList<>()).getContent());
        assertContentEquals(new File("static/css/bootstrap.css"), actual);
        weBrInstance.stop();
    }
}