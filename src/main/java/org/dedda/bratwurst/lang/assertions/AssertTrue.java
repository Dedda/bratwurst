package org.dedda.bratwurst.lang.assertions;

import org.dedda.bratwurst.lang.BWInstruction;
import org.dedda.bratwurst.lang.BWInteger;
import org.dedda.bratwurst.lang.BWVariable;
import org.dedda.bratwurst.lang.scope.Scope;
import org.dedda.bratwurst.test.TestFileRunner;

/**
 * Created by dedda on 1/23/16.
 *
 * @author dedda
 */
public class AssertTrue extends BWInstruction {

    private String variableName;

    public AssertTrue(int lineNumber, String variableName) {
        super(lineNumber);
        this.variableName = variableName;
    }

    @Override
    public void run(Scope scope) {
        if (!scope.isInTest()) {
            return;
        }
        TestFileRunner testFileRunner = scope.getTestFileRunner();
        testFileRunner.incAssertions();
        BWVariable var = scope.getVariable(variableName);
        String message = null;
        if (!(var.getValue() instanceof BWInteger)) {
            message = "variable is not a number!";
        } else if (var.getIntValue() == 0) {
            message = "variable is false!";
        }
        if (message != null) {
            message = "ERROR asserting variable is true --> " + getLineNumber() + ": " + message;
            scope.getTestFunctionRunner().fail(message);
        } else {
            System.out.print(".");
        }
    }
}
