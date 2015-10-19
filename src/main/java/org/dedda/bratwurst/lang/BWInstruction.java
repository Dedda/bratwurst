package org.dedda.bratwurst.lang;

import java.util.Arrays;
import java.util.Optional;

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

    public BWObject substituteVariableName(String variableName) {
        BWObject object = null;
        if (Program.getInstance().getVariable(variableName) != null) {
            object = Program.getInstance().getVariable(variableName).getValue();
        }
        return object;
    }

    protected BWVariable getArgument(final String name) {
        Optional<BWVariable> variableOptional = Arrays.stream(arguments).filter(v -> v.getName().equals(name)).findFirst();
        if (variableOptional.isPresent()) {
            return variableOptional.get();
        }
        return null;
    }

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
