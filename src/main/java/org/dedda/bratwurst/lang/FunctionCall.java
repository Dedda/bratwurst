package org.dedda.bratwurst.lang;

/**
 * Created by dedda on 10/16/15.
 *
 * @author dedda
 */
public class FunctionCall extends BWExpression {

    private String variableName = "";
    private String functionName;
    private BWObject value = new BWInteger(0);
    private BWVariable[] functionArguments;

    public FunctionCall(String functionName, BWVariable[] functionArguments) {
        this.functionName = functionName;
        this.functionArguments = functionArguments;
    }

    public FunctionCall(String variableName, String functionName, BWVariable[] functionArguments) {
        this.variableName = variableName;
        this.functionName = functionName;
        this.functionArguments = functionArguments;
    }

    @Override
    public BWObject getValue() {
        return value;
    }

    @Override
    public int getIntValue() {
        return value.getIntValue();
    }

    @Override
    public String getValueType() {
        return value.getValueType();
    }

    @Override
    public void run(Scope scope) {
        BWFunction function = null;
        if (!variableName.equals("")) {
            function = scope.getFunction(variableName, functionName);
        }
        if (function == null) {
            function = scope.getFunction(functionName);
        }
        if (function == null) {
            throw new RuntimeException("function " + variableName + "." + functionName + " not set!");
        }
        scope = new Scope(scope.getVariable(variableName).getValue());
        function.setArguments(functionArguments);
        function.run(scope);
        value = function.getValue();
    }
}
