package org.dedda.bratwurst.lang;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by dedda on 10/14/15.
 *
 * @author dedda
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
    private BWVariable[][] arguments;

    private Program() {

    }

    public void run() {
        for (int i = 0; i < instructions.length; i++) {
            instructions[i].run(new Scope(null, arguments[i]));
        }
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

    public void registerVariable(BWVariable variable) {
        List<BWVariable> variableList = Arrays.stream(this.variables).collect(Collectors.toList());
        variableList.add(variable);
        this.variables = new BWVariable[variableList.size()];
        variableList.toArray(this.variables);
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

    public BWVariable[][] getArguments() {
        return arguments;
    }

    public void setArguments(BWVariable[][] arguments) {
        this.arguments = arguments;
    }
}
