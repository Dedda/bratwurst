package org.dedda.bratwurst.lang;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by dedda on 10/14/15.
 *
 * @author dedda
 */
public class Scope {

    private BWObject currentObject;

    public Scope(BWObject currentObject) {
        this.currentObject = currentObject;
    }

    public BWObject getCurrentObject() {
        return currentObject;
    }

    public boolean isInObject() {
        return currentObject != null;
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

    public BWFunction getFunction(String functionName) {
        BWFunction function = null;
        List<BWFunction> functionList = Arrays.stream(Program.getInstance().getFunctions()).collect(Collectors.toList());
        if (isInObject()) {
            Arrays.stream(currentObject.getFunctions()).forEach(f -> functionList.add(f));
        }
        Optional<BWFunction> functionOptional = functionList.stream().filter(f -> f.getName().equals(functionName)).findFirst();
        if (functionOptional.isPresent()) {
            function = functionOptional.get();
        }
        return function;
    }

    public BWFunction getFunction(String variableName, String functionName) {
        BWFunction function = null;
        BWVariable variable = getVariable(variableName);
        if (variable == null) {
            throw new RuntimeException("variable " + variableName + " not defined!");
        }
        Optional<BWFunction> functionOptional = Arrays.stream(variable.getValue().getFunctions()).filter(f -> f.getName().equals(functionName)).findFirst();
        if (functionOptional.isPresent()) {
            function = functionOptional.get();
        } else {
            throw new RuntimeException("function " + functionName + " not defined!");
        }
        return function;
    }

}
