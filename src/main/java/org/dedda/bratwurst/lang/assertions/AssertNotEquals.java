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
public class AssertNotEquals extends BWInstruction {

    private String variableName1;
    private String variableName2;

    public AssertNotEquals(int lineNumber, String variableName1, String variableName2) {
        super(lineNumber);
        this.variableName1 = variableName1;
        this.variableName2 = variableName2;
    }

    @Override
    public void run(Scope scope) {
        if (!scope.isInTest()) {
            return;
        }
        TestRunner testRunner = scope.getTestRunner();
        testRunner.incAssertions();
        BWVariable var1 = scope.getVariable(variableName1);
        BWVariable var2 = scope.getVariable(variableName2);
        String message = null;
        if (!var1.getValue().getClass().equals(var2.getValue().getClass())) {
            return;
        } else if (var1.getValue() instanceof BWInteger) {
            if (assertEqualsInteger(var1, var2)) {
                message = "Integers (" + var1.getIntValue() + ") and (" + var2.getIntValue() + ") equal!";
            }
        } else if (var1.getValue() instanceof BWString) {
            if (assertEqualsString(var1, var2)) {
                message = "Strings (" + ((BWString) var1.getValue()).getStringValue() + ") and ("
                        + ((BWString) var2.getValue()).getStringValue() + ") equal!";
            }
        } else if (var1.getValue() instanceof BWObject) {
            if (assertEqualsObject(var1, var2)) {
                message = "Objects of equal type!";
            }
        }
        if (message != null) {
            message = "ERROR asserting two variables are not equal --> " + getLineNumber() + ": " + message;
            scope.getTestFunctionRunner().fail(message);
        } else {
            System.out.print(".");
        }
    }

    protected boolean assertEqualsInteger(BWVariable var1, BWVariable var2) {
        return var1.getIntValue() == var2.getIntValue();
    }

    protected boolean assertEqualsString(BWVariable var1, BWVariable var2) {
        return ((BWString) var1.getValue()).getStringValue().equals(((BWString) var2.getValue()).getStringValue());
    }

    protected boolean assertEqualsObject(BWVariable var1, BWVariable var2) {
        return var1.getValue().getBwClass().name.equals(var2.getValue().getBwClass().name);
    }

}
