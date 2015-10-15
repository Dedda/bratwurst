package org.dedda.bratwurst.lang;

import java.util.Arrays;

/**
 * Created by dedda on 10/15/15.
 *
 * @author dedda
 */
public class VariableDeclaration extends BWInstruction {

    private String variableName;
    private BWExpression targetValue;

    public VariableDeclaration(String variableName, BWExpression targetValue) {
        this.variableName = variableName;
        this.targetValue = targetValue;
    }

    @Override
    public void run(Scope scope) {
        targetValue.run(scope);
        BWObject value = targetValue.getValue();
        BWVariable variable = new BWVariable(variableName, value);
        scope.registerVariable(variable);
    }
}
