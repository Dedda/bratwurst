package org.dedda.bratwurst.lang;

import org.dedda.bratwurst.lang.scope.Scope;

import java.util.Arrays;

/**
 * Created by dedda on 10/16/15.
 *
 * @author dedda
 */
public class FunctionCall extends BWExpression {

    private final String functionName;
    private String variableName = "";
    private BWObject value = new BWInteger(0);

    public FunctionCall(int lineNumber, String functionName, BWVariable[] functionArguments) {
        super(lineNumber);
        this.functionName = functionName;
        setArguments(functionArguments);
    }

    public FunctionCall(int lineNumber, String variableName, String functionName, BWVariable[] functionArguments) {
        super(lineNumber);
        this.variableName = variableName;
        this.functionName = functionName;
        setArguments(functionArguments);
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
            throw new RuntimeException(getLineNumber() + ": function " + variableName + "." + functionName + " not set!");
        }
        for (BWVariable argument : getArguments()) {
            argument.run(scope);
        }
        if (!variableName.equals("")) {
//            scope = new Scope(scope.getVariable(variableName).getValue());
            scope.enterFunction(scope.getVariable(variableName).getValue(), function, Arrays.asList(getArguments()));
        } else {
            scope.enterFunction(function, Arrays.asList(getArguments()));
        }
        function.setArguments(getArguments());
        function.run(scope);
        value = function.getValue();
        scope.leaveFunction();
    }
}
