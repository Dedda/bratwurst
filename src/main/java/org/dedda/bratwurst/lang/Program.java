package org.dedda.bratwurst.lang;

import java.util.Arrays;

/**
 * Created by dedda on 10/14/15.
 */
public class Program {
    private static Program instance = new Program();

    public static Program getInstance() {
        return instance;
    }

    private BWFunction[] functions;
    private BWClass[] classes;
    private BWVariable[] variables;
    private BWInstruction[] instructions;

    private Program() {
    }

    public BWObject callFunction(String functionName, BWVariable[] arguments) {
        BWFunction function = Arrays.stream(functions).filter(f -> f.getName().equals(functionName)).findFirst().get();
        Scope scope = new Scope(null, arguments);
        function.run(scope);
        return function.getValue();
    }

    public BWObject callVariableFunction(String variableName, String functionName, BWVariable[] arguments) {
        BWFunction function = Arrays.stream(functions).filter(f -> f.getName().equals(functionName)).findFirst().get();
        BWObject object = Arrays.stream(variables).filter(o -> o.getName().equals(variableName)).findFirst().get().getValue();
        Scope scope = new Scope(object, arguments);
        function.run(scope);
        return function.getValue();
    }

    public void run() {

    }

    public void registerVariable(BWVariable variable) {

    }

    public BWFunction[] getFunctions() {
        return functions;
    }

    public void setFunctions(BWFunction[] functions) {
        this.functions = functions;
    }

    public BWClass[] getClasses() {
        return classes;
    }

    public void setClasses(BWClass[] classes) {
        this.classes = classes;
    }

    public BWVariable[] getVariables() {
        return variables;
    }

    public void setVariables(BWVariable[] variables) {
        this.variables = variables;
    }

    public BWInstruction[] getInstructions() {
        return instructions;
    }

    public void setInstructions(BWInstruction[] instructions) {
        this.instructions = instructions;
    }
}
