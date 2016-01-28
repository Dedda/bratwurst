package org.dedda.bratwurst.gui;

import javax.swing.*;
import java.util.HashMap;

/**
 * Created by dedda on 1/28/16.
 *
 * @author dedda
 */
public class WindowMap extends HashMap<String, JFrame> {

    public String createWindow() {
        String id = "window-" + System.currentTimeMillis();
        put(id, new JFrame());
        return id;
    }

    public void createWindow(String id) {
        if (containsKey(id)) {
            throw new RuntimeException("Window with id already exists");
        }
        put(id, new JFrame());
    }

    public void closeAll() {
        for (JFrame frame : values()) {
            frame.setVisible(false);
            frame.dispose();
        }
    }

}
