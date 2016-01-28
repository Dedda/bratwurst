package org.dedda.bratwurst.lang;

import org.dedda.bratwurst.lang.scope.Scope;

/**
 * Created by dedda on 1/28/16.
 *
 * @author dedda
 */
public class IntToChar extends BWExpression {

    private String varname;
    private char value;

    public IntToChar(int lineNumber, String varname) {
        super(lineNumber);
        this.varname = varname;
    }

    @Override
    public BWObject getValue() {
        return new BWString(value + "");
    }

    @Override
    public int getIntValue() {
        return value;
    }

    @Override
    public String getValueType() {
        return "string";
    }

    @Override
    public void run(Scope scope) {
        BWVariable variable = scope.getVariable(varname);
        if (!(variable.getValue() instanceof BWInteger)) {
            throw new RuntimeException("Variable not of type integer");
        }
        value = (char) variable.getValue().getIntValue();
    }
}
