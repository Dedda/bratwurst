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

    public Condition(final int lineNumber, final BWExpression toEvaluate, final BWInstruction[] trueInstructions, final BWInstruction[] falseInstructions) {
        super(lineNumber);
        this.toEvaluate = toEvaluate;
        this.trueInstructions = trueInstructions;
        this.falseInstructions = falseInstructions;
    }

    @Override
    public void run(final Scope scope) {
        toEvaluate.run(scope);
        final BWInstruction[] toRun = toEvaluate.getIntValue() == 0 ? falseInstructions : trueInstructions;
        for (final BWInstruction instruction : toRun) {
            instruction.run(scope);
        }
    }
}
