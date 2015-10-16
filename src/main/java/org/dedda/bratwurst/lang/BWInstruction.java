package org.dedda.bratwurst.lang;

import java.util.Arrays;
import java.util.Optional;

/**
 * Created by dedda on 10/14/15.
 *
 * @author dedda
 */
public abstract class BWInstruction {

    private BWVariable[] arguments;

    public abstract void run(Scope scope);

    public BWObject substituteVariableName(String variableName) {
        BWObject object = null;
        if (Arrays.stream(Program.getInstance().getVariables()).filter(v -> v.getName().equals(variableName)).findFirst().isPresent()) {
            object = Arrays.stream(Program.getInstance().getVariables()).filter(v -> v.getName().equals(variableName)).findFirst().get().getValue();
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
}
