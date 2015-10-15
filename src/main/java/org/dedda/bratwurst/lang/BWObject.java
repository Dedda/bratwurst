package org.dedda.bratwurst.lang;

import java.util.Arrays;

/**
 * Created by dedda on 10/14/15.
 *
 * @author dedda
 */
public class BWObject {

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
}
