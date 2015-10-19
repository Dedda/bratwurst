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

    private BWObject currentObject = null;

    private BWFunction currentFunction = null;

    public Scope() {
    }

    public Scope(BWObject currentObject) {
        this.currentObject = currentObject;
    }

    public Scope(BWFunction currentFunction) {
        this.currentFunction = currentFunction;
    }

    public Scope(BWObject currentObject, BWFunction currentFunction) {
        this.currentObject = currentObject;
        this.currentFunction = currentFunction;
    }

    public BWObject getCurrentObject() {
        return currentObject;
    }

    public boolean isInObject() {
        return currentObject != null;
    }

    public boolean isInFunction() {
        return currentFunction != null;
    }

    public void registerVariable(BWVariable variable) {
        if (isInObject()) {
            currentObject.addVariable(variable);
        } else if (isInFunction()) {
            currentFunction.getVariables().add(variable);
        } else {
            Program.getInstance().registerVariable(variable);
        }
    }

    public BWVariable getVariable(final String variableName) {
        if (isInFunction()) {
            Optional<BWVariable> variableOptional = currentFunction.getVariables().stream().filter(v -> v.getName().equals(variableName)).findFirst();
            if (variableOptional.isPresent()) {
                return variableOptional.get();
            }
        }
        if (isInObject()) {
            Optional<BWVariable> variableOptional = Arrays.stream(currentObject.getVariables()).filter(v -> v.getName().equals(variableName)).findFirst();
            if (variableOptional.isPresent()) {
                return variableOptional.get();
            }
        }
        return Program.getInstance().getVariable(variableName);
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

    public void registerClass(BWClass bwClass) {
        Program.getInstance().registerClass(bwClass);
    }

}
