package org.dedda.bratwurst.gui;

import org.dedda.bratwurst.lang.scope.Scope;

import javax.swing.*;
import java.util.Map;

/**
 * Created by dedda on 1/28/16.
 *
 * @author dedda
 */
public class WindowSet extends GuiCommandConsumer {

    public static final String KEY_ATTRIBUTE = "attr";
    public static final String KEY_WIDTH = "width";
    public static final String KEY_HEIGHT = "height";

    private final WindowMap windowMap;

    public WindowSet(WindowMap windowMap) {
        this.windowMap = windowMap;
    }

    @Override
    public String consume(Map<String, String> arguments, Scope scope) {
        if (!(arguments.containsKey(KEY_ATTRIBUTE) && arguments.containsKey("val") && arguments.containsKey("id"))) {
            throw new RuntimeException("Attribute, id or value to set not given");
        }
        final String attr = arguments.get(KEY_ATTRIBUTE);
        switch (attr) {
            case KEY_WIDTH: setWidth(arguments, scope);
                            break;
            case KEY_HEIGHT: setHeight(arguments, scope);
                            break;
        }
        return "1";
    }

    private void setWidth(Map<String, String> arguments, Scope scope) {
        JFrame frame = windowMap.get(getStringFromScope(scope, arguments.get("id")));
        frame.setSize(getIntFromScope(scope, arguments.get("val")), frame.getHeight());
    }

    private void setHeight(Map<String, String> arguments, Scope scope) {
        JFrame frame = windowMap.get(getStringFromScope(scope, arguments.get("id")));
        frame.setSize(frame.getWidth(), getIntFromScope(scope, arguments.get("val")));
    }

}
