package org.dedda.bratwurst.lang;

import org.dedda.bratwurst.lang.scope.Scope;

/**
 * Created by dedda on 1/28/16.
 *
 * @author dedda
 */
public class CharToInt extends BWExpression {

    private final String varname;
    private int value;

    public CharToInt(int lineNumber, String varname) {
        super(lineNumber);
        this.varname = varname;
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
        BWVariable variable = scope.getVariable(varname);
        if (!(variable.getValue() instanceof BWString)) {
            throw new RuntimeException("Variable not of type string");
        }
        BWString value = (BWString) variable.getValue();
        if (value.getStringValue().length() != 1) {
            throw new RuntimeException("String not length of 1");
        }
        this.value = value.getStringValue().charAt(0);
    }
}
