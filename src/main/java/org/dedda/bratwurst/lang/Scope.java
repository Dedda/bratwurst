package org.dedda.bratwurst.lang;

import java.util.Arrays;

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
        throw new UnsupportedOperationException();
    }

    public BWVariable getVariable(final String variableName) {
        BWVariable variable = null;
        if (isInObject()) {
            variable = Arrays.stream(currentObject.getVariables()).filter(v -> v.getName().equals(variableName)).findFirst().get();
        }
        if (variable == null) {
            variable = Arrays.stream(Program.getInstance().getVariables()).filter(v -> v.getName().equals(variableName)).findFirst().get();
        }
        return variable;
    }

}
