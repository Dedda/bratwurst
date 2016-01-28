package org.dedda.bratwurst.gui;

import org.dedda.bratwurst.lang.scope.Scope;

import java.util.Map;

import static org.dedda.bratwurst.gui.GuiContainer.SUCCESS;

/**
 * Created by dedda on 1/28/16.
 *
 * @author dedda
 */
public class WindowCreate extends GuiCommandConsumer {

    private WindowMap windowMap;

    public WindowCreate(WindowMap windowMap) {
        this.windowMap = windowMap;
    }

    @Override
    public String consume(Map<String, String> arguments, Scope scope) {
        if (arguments.containsKey("id")) {
            windowMap.createWindow(arguments.get("id"));
            windowMap.get(arguments.get("id")).setVisible(true);
            return SUCCESS;
        }
        String id = windowMap.createWindow();
        windowMap.get(id).setVisible(true);
        return id;
    }
}
