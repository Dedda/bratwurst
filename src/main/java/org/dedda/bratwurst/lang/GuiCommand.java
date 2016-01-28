package org.dedda.bratwurst.lang;

import org.dedda.bratwurst.lang.scope.Scope;

import java.util.Map;

/**
 * Created by dedda on 1/28/16.
 *
 * @author dedda
 */
public class GuiCommand extends BWExpression {

    private Map<String, String> arguments;
    private String value;

    public GuiCommand(int lineNumber, Map<String, String> arguments) {
        super(lineNumber);
        this.arguments = arguments;
    }

    @Override
    public BWObject getValue() {
        return new BWString(value);
    }

    @Override
    public int getIntValue() {
        return getValue().getIntValue();
    }

    @Override
    public String getValueType() {
        return "string";
    }

    @Override
    public void run(Scope scope) {
        value = scope.getProgram().getGuiContainer().acceptCommand(arguments, scope);
    }
}
