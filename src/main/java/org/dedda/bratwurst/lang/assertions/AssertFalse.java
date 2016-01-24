package org.dedda.bratwurst.lang.assertions;

import org.dedda.bratwurst.lang.*;
import org.dedda.bratwurst.lang.scope.Scope;
import org.dedda.bratwurst.test.TestRunner;

import java.util.Arrays;
import java.util.Optional;

/**
 * Created by dedda on 1/23/16.
 *
 * @author dedda
 */
public class AssertFalse extends BWInstruction {

    private String variableName;

    public AssertFalse(int lineNumber, String variableName) {
        super(lineNumber);
        this.variableName = variableName;
    }

    @Override
    public void run(Scope scope) {
        if (!scope.isInTest()) {
            return;
        }
        TestRunner testRunner = scope.getTestRunner();
        testRunner.incAssertions();
        BWVariable var = scope.getVariable(variableName);
        String message = null;
        if (!(var.getValue() instanceof BWInteger)) {
            message = "variable is not a number!";
        } else if (var.getIntValue() != 0) {
            message = "variable is true (" + var.getIntValue() + ")!";
        }
        if (message != null) {
            message = "ERROR asserting variable is true --> " + getLineNumber() + ": " + message;
            scope.getTestFunctionRunner().fail(message);
        } else {
            System.out.print(".");
        }
    }
}
