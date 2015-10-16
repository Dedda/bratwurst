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

    public Condition(BWExpression toEvaluate, BWInstruction[] trueInstructions, BWInstruction[] falseInstructions) {
        this.toEvaluate = toEvaluate;
        this.trueInstructions = trueInstructions;
        this.falseInstructions = falseInstructions;
    }

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
        for (int i = 0; i < trueInstructions.length; i++) {
            trueInstructions[i].run(scope);
        }
    }

    private void runFalse(Scope scope) {
        for (int i = 0; i < falseInstructions.length; i++) {
            falseInstructions[i].run(scope);
        }
    }

}
