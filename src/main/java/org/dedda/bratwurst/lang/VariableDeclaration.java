package org.dedda.bratwurst.lang;

import java.util.Arrays;

/**
 * Created by dedda on 10/15/15.
 *
 * @author dedda
 */
public class VariableDeclaration implements BWInstruction {

    private String variableName;
    private BWExpression targetValue;

    @Override
    public void run(Scope scope) {
        targetValue.run(scope);
        BWObject value = targetValue.getValue();
        BWVariable variable = new BWVariable(variableName, value);
        scope.registerVariable(variable);
    }
}
