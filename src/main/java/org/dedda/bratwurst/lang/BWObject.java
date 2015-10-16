package org.dedda.bratwurst.lang;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by dedda on 10/14/15.
 *
 * @author dedda
 */
public class BWObject extends BWExpression {

    private BWClass bwClass;
    private BWVariable[] variables;
    private BWObjectFunction[] functions;

    public BWObject(BWClass bwClass, BWVariable[] variables, BWObjectFunction[] functions) {
        this.bwClass = bwClass;
        this.variables = variables;
        this.functions = functions;
    }

    public BWClass getBwClass() {
        return bwClass;
    }

    public BWVariable[] getVariables() {
        return variables;
    }

    public void addVariable(BWVariable variable) {
        List<BWVariable> variableList = Arrays.stream(variables).collect(Collectors.toList());
        variableList.add(variable);
        variables = new BWVariable[variableList.size()];
        variableList.toArray(variables);
    }

    public BWFunction[] getFunctions() {
        return functions;
    }

    public BWObject callFunction(String functionName, BWVariable[] arugments) {
        BWFunction function = Arrays.stream(functions).filter(f -> f.getName().equals(functionName)).findFirst().get();
        Scope scope = new Scope(this, arugments);
        function.run(scope);
        return function.getValue();
    }

    public void setFunctions(BWObjectFunction[] functions) {
        this.functions = functions;
    }

    public void setVariables(BWVariable[] variables) {
        this.variables = variables;
    }

    @Override
    public BWObject getValue() {
        return this;
    }

    @Override
    public int getIntValue() {
        return 0;
    }

    @Override
    public String getValueType() {
        return "object";
    }

    @Override
    public void run(Scope scope) {}
}
