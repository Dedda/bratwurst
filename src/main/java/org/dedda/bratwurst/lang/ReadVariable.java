package org.dedda.bratwurst.lang;

/**
 * Created by dedda on 10/16/15.
 *
 * @author dedda
 */
public class ReadVariable extends BWExpression {

    private String variableName;
    private BWObject value = new BWInteger(0);

    public ReadVariable(String variableName) {
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
        value = scope.getVariable(variableName).getValue();
    }
}