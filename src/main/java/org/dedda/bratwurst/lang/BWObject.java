package org.dedda.bratwurst.lang;

/**
 * Created by dedda on 10/14/15.
 *
 * @author dedda
 */
public class BWObject {

    private BWClass bwClass;
    private BWVariable[] variables;
    private BWFunction[] functions;

    public BWObject(BWClass bwClass, BWVariable[] variables, BWFunction[] functions) {
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

    public BWFunction[] getFunctions() {
        return functions;
    }

    public BWObject callFunction(String functionName) {

    }

}
