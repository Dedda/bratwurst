package org.dedda.bratwurst.lang;

import org.dedda.bratwurst.lang.scope.Scope;

/**
 * Created by dedda on 10/15/15.
 *
 * @author dedda
 */
public class Loop extends BWInstruction {

    private final BWExpression toEvaluate;

    private final BWInstruction[] instructions;

    public Loop(int lineNumber, BWExpression toEvaluate, BWInstruction[] instructions) {
        super(lineNumber);
        this.toEvaluate = toEvaluate;
        this.instructions = instructions;
    }

    @Override
    public void run(Scope scope) {
        boolean run;
        toEvaluate.run(scope);
        run = toEvaluate.getIntValue() != 0;
        while (run) {
            runInstructions(scope);
            toEvaluate.run(scope);
            run = toEvaluate.getIntValue() != 0;
        }
    }

    private void runInstructions(Scope scope) {
        for (BWInstruction instruction : instructions) {
            instruction.run(scope);
        }
    }

}
