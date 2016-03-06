package org.dedda.bratwurst.lang;

import org.dedda.bratwurst.lang.scope.Scope;

/**
 * Created by dedda on 10/16/15.
 *
 * @author dedda
 */
public class ReadVariable extends BWExpression {

    private final String variableName;
    private BWObject value = new BWInteger(0);

    public ReadVariable(int lineNumber, String variableName) {
        super(lineNumber);
        this.variableName = variableName;
    }

    @Override
    public BWObject getValue() {
        return value;
    }

    @Override
    public int getIntValue() {
        return value.getIntValue();
    }

    @Override
    public String getValueType() {
        return value.getValueType();
    }

    @Override
    public void run(Scope scope) {
        BWVariable variable = scope.getVariable(variableName);
        if (variable != null) {
            value = variable.getValue();
        } else {
            throw new RuntimeException("Variable " + variableName + " is not defined!");
        }
    }
}
