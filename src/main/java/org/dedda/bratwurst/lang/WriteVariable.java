package org.dedda.bratwurst.lang;

/**
 * Created by dedda on 10/16/15.
 *
 * @author dedda
 */
public class WriteVariable extends BWInstruction {

    private String variableName;
    private BWExpression variableValue;

    public WriteVariable(String variableName, BWExpression variableValue) {
        this.variableName = variableName;
        this.variableValue = variableValue;
    }

    @Override
    public void run(Scope scope) {
        variableValue.run(scope);
        scope.registerVariable(new BWVariable(variableName, variableValue.getValue()));
    }
}
