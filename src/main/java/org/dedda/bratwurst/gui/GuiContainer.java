package org.dedda.bratwurst.gui;

import org.dedda.bratwurst.lang.scope.Scope;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by dedda on 1/28/16.
 *
 * @author dedda
 */
public class GuiContainer {

    public static final String SUCCESS = "1";
    public static final String FAILURE = "0";

    public static final String WINDOW_CREATE = "win-create";
    public static final String WINDOW_SET = "win-set";

    private final WindowMap windows;
    private final Map<String, GuiCommandConsumer> consumers;

    public GuiContainer() {
        windows = new WindowMap();
        consumers = new HashMap<>();
        consumers.put(WINDOW_CREATE, new WindowCreate(windows));
        consumers.put(WINDOW_SET, new WindowSet(windows));
    }

    public String acceptCommand(Map<String, String> arguments, Scope scope) {
        if (!arguments.containsKey("action")) {
            throw new RuntimeException("No action set");
        }
        String command = arguments.get("action");
        if (!consumers.containsKey(command)) {
            throw new RuntimeException("Unknown action: " + command);
        }
        return consumers.get(command).consume(arguments, scope);
    }

    public void close() {
        windows.closeAll();
    }

}
