package org.dedda.bratwurst.lang;

/**
 * Created by dedda on 10/15/15.
 *
 * @author dedda
 */
public class Condition extends BWInstruction {

    private BWExpression toEvaluate;

    private BWInstruction[] trueInstructions;
    private BWInstruction[] falseInstructions;

    @Override
    public void run(Scope scope) {
        toEvaluate.run(scope);
        if (toEvaluate.getIntValue() != 0) {
            runTrue(scope);
        } else {
            runFalse(scope);
        }
    }

    private void runTrue(Scope scope) {

    }

    private void runFalse(Scope scope) {

    }

}
