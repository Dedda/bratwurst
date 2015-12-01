package org.dedda.bratwurst.lang;

import org.dedda.bratwurst.lang.scope.Scope;

/**
 * Created by dedda on 10/14/15.
 *
 * @author dedda
 */
public abstract class BWInstruction {

    private int lineNumber;
    private BWVariable[] arguments;

    public BWInstruction(int lineNumber) {
        this.lineNumber = lineNumber;
    }

    public abstract void run(Scope scope);

    public BWVariable[] getArguments() {
        return arguments;
    }

    public void setArguments(BWVariable[] arguments) {
        this.arguments = arguments;
    }

    public int getLineNumber() {
        return lineNumber;
    }
}
