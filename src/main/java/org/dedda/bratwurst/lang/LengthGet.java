package org.dedda.bratwurst.lang;

import org.dedda.bratwurst.lang.scope.Scope;

/**
 * Created by dedda on 1/25/16.
 *
 * @author dedda
 */
public class LengthGet extends BWExpression {

    public final String varName;
    private int value;

    public LengthGet(int lineNumber, String varName) {
        super(lineNumber);
        this.varName = varName;
    }

    @Override
    public BWObject getValue() {
        return new BWInteger(value);
    }

    @Override
    public int getIntValue() {
        return value;
    }

    @Override
    public String getValueType() {
        return "integer";
    }

    @Override
    public void run(Scope scope) {
        BWVariable variable = scope.getVariable(varName);
        if (variable.getValue() instanceof BWString) {
            value = ((BWString) variable.getValue()).getStringValue().length();
        } else {
            throw new RuntimeException("variable not of type string!");
        }
    }
}
