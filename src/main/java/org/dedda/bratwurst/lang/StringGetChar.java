package org.dedda.bratwurst.lang;

import org.dedda.bratwurst.lang.scope.Scope;

/**
 * Created by dedda on 1/25/16.
 *
 * @author dedda
 */
public class StringGetChar extends BWExpression {

    private final String location;
    private final String varName;
    private String value = "";

    public StringGetChar(int lineNumber, String location, String varName) {
        super(lineNumber);
        this.location = location;
        this.varName = varName;
    }

    @Override
    public BWObject getValue() {
        return new BWString(value);
    }

    @Override
    public int getIntValue() {
        if (value.matches("\\d+")) {
            return Integer.parseInt(value);
        }
        return 0;
    }

    @Override
    public String getValueType() {
        return "string";
    }

    @Override
    public void run(Scope scope) {
        int location;
        if (this.location.matches("\\d+")) {
            location = Integer.parseInt(this.location);
        } else {
            BWVariable locVar = scope.getVariable(this.location);
            if (locVar.getValue() instanceof BWString) {
                if (((BWString) locVar.getValue()).getStringValue().matches("\\d+")) {
                    location = locVar.getIntValue();
                } else {
                    throw new RuntimeException("location is not a number!");
                }
            } else if (locVar.getValue() instanceof BWInteger) {
                location = locVar.getIntValue();
            } else {
                throw new RuntimeException("location not of type string or integer");
            }
        }
        BWVariable variable = scope.getVariable(varName);
        String text;
        if (variable.getValue() instanceof BWString) {
            text = ((BWString) variable.getValue()).getStringValue();
        } else if (variable.getValue() instanceof BWInteger) {
            text = "" + variable.getIntValue();
        } else {
            throw new RuntimeException("variable not of type string or integer");
        }
        value = "" + text.charAt(location);
    }
}
