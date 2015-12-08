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
        scope.setVariable(new BWVariable(variableName, scope.pop()));
    }

    public String getVariableName() {
        return variableName;
    }
}
