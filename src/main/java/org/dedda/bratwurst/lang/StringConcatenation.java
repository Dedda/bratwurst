package org.dedda.bratwurst.lang;

import org.dedda.bratwurst.lang.scope.Scope;

/**
 * Created by dedda on 1/25/16.
 *
 * @author dedda
 */
public class StringConcatenation extends BWExpression {

    private final String[] variableNames;
    private String value = "";

    public StringConcatenation(int lineNumber, String[] variableNames) {
        super(lineNumber);
        this.variableNames = variableNames;
    }

    @Override
    public BWObject getValue() {
        return new BWString(value);
    }

    @Override
    public int getIntValue() {
        int value = 0;
        try {
            value = Integer.parseInt(((BWString) getValue()).getStringValue());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return value;
    }

    @Override
    public String getValueType() {
        return "string";
    }

    @Override
    public void run(Scope scope) {
        String[] strings = new String[variableNames.length];
        for (int i = 0; i < variableNames.length; i++) {
            BWVariable variable = scope.getVariable(variableNames[i]);
            if (variable.getValue() instanceof BWString) {
                strings[i] = ((BWString) variable.getValue()).getStringValue();
            } else if (variable.getValue() instanceof BWInteger) {
                strings[i] = "" + variable.getValue().getIntValue();
            } else {
                throw new RuntimeException("variable not string or integer!");
            }
        }
        String data = "";
        for (String string : strings) {
            data += string;
        }
        this.value = data;
    }
}
