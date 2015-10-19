package org.dedda.bratwurst.lang;

/**
 * Created by dedda on 10/15/15.
 *
 * @author dedda
 */
public class VariableDeclaration extends BWInstruction {

    private String variableName;
    private BWExpression targetValue;

    public VariableDeclaration(int lineNumber, String variableName, BWExpression targetValue) {
        super(lineNumber);
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

    public String getVariableName() {
        return variableName;
    }
}
