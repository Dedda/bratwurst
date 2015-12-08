package org.dedda.bratwurst.lang;

import org.dedda.bratwurst.lang.scope.Scope;

/**
 * Created by dedda on 12/8/15.
 *
 * @author dedda
 */
public class Pop extends BWInstruction {

    private String variableName;

    public Pop(int lineNumber, String variableName) {
        super(lineNumber);
        this.variableName = variableName;
    }

    @Override
    public void run(Scope scope) {
        BWExpression value = scope.pop();
        BWVariable variable = new BWVariable(variableName, value);
        variable.run(scope);
        scope.setVariable(variable);
    }

    public String getVariableName() {
        return variableName;
    }
}
