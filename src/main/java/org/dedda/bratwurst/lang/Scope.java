package org.dedda.bratwurst.lang;

import java.util.Arrays;
import java.util.Optional;

/**
 * Created by dedda on 10/14/15.
 *
 * @author dedda
 */
public class Scope {

    private BWObject currentObject;
    private BWVariable[] arguments;

    public Scope(BWObject currentObject, BWVariable[] arguments) {
        this.currentObject = currentObject;
        this.arguments = arguments;
    }

    public BWObject getCurrentObject() {
        return currentObject;
    }

    public boolean isInObject() {
        return currentObject != null;
    }

    public BWVariable[] getArguments() {
        return arguments;
    }

    public void registerVariable(BWVariable variable) {
        if (isInObject()) {
            currentObject.addVariable(variable);
        } else {
            Program.getInstance().registerVariable(variable);
        }
    }

    public BWVariable getVariable(final String variableName) {
        BWVariable variable = null;
        if (isInObject()) {
            Optional<BWVariable> variableOptional = Arrays.stream(currentObject.getVariables()).filter(v -> v.getName().equals(variableName)).findFirst();
            if (variableOptional.isPresent()) {
                variable = variableOptional.get();
            }
        }
        if (variable == null) {
            variable = Arrays.stream(Program.getInstance().getVariables()).filter(v -> v.getName().equals(variableName)).findFirst().get();
        }
        return variable;
    }

}
