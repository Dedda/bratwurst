package org.dedda.bratwurst.lang;

import org.dedda.bratwurst.lang.scope.Scope;

/**
 * Created by dedda on 10/14/15.
 *
 * @author dedda
 */
public class PrintVariable extends BWInstruction {

    private String variableName;

    public PrintVariable(int lineNumber, String variableName) {
        super(lineNumber);
        this.variableName = variableName;
    }

    @Override
    public void run(Scope scope) {
        BWVariable variable = scope.getVariable(variableName);
        if (variable.getValue() instanceof BWString) {
            System.out.print(((BWString) variable.getValue()).getStringValue());
        } else {
            char character = (char) variable.getIntValue();
            System.out.print(character);
        }
    }

    public String getVariableName() {
        return variableName;
    }
}
