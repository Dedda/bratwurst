package org.dedda.bratwurst.gui;

import org.dedda.bratwurst.lang.BWString;
import org.dedda.bratwurst.lang.BWVariable;
import org.dedda.bratwurst.lang.scope.Scope;

import java.util.Map;

/**
 * Created by dedda on 1/28/16.
 *
 * @author dedda
 */
public abstract class GuiCommandConsumer {

    public abstract String consume(Map<String, String> arguments, Scope scope);

    protected int getIntFromScope(Scope scope, String name) {
        BWVariable var = scope.getVariable(name);
        return var.getValue().getIntValue();
    }

    protected String getStringFromScope(Scope scope, String name) {
        BWVariable var = scope.getVariable(name);
        if (var.getValue() instanceof BWString) {
            return ((BWString) var.getValue()).getStringValue();
        }
        return null;
    }

}
