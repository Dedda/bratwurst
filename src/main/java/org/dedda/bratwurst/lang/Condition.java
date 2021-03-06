package org.dedda.bratwurst.lang;

import org.dedda.bratwurst.lang.scope.Scope;

/**
 * Created by dedda on 10/15/15.
 *
 * @author dedda
 */
public class Condition extends BWInstruction {

    private final BWExpression toEvaluate;

    private final BWInstruction[] trueInstructions;
    private final BWInstruction[] falseInstructions;

    public Condition(int lineNumber, BWExpression toEvaluate, BWInstruction[] trueInstructions, BWInstruction[] falseInstructions) {
        super(lineNumber);
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
        for (BWInstruction trueInstruction : trueInstructions) {
            trueInstruction.run(scope);
        }
    }

    private void runFalse(Scope scope) {
        for (BWInstruction falseInstruction : falseInstructions) {
            falseInstruction.run(scope);
        }
    }

}
