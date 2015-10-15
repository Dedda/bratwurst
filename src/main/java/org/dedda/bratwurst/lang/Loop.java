package org.dedda.bratwurst.lang;

/**
 * Created by dedda on 10/15/15.
 *
 * @author dedda
 */
public class Loop implements BWInstruction {

    private BWExpression toEvaluate;

    private BWInstruction[] instructions;

    @Override
    public void run(Scope scope) {
        boolean run = false;
        toEvaluate.run(scope);
        run = toEvaluate.getIntValue() != 0;
        while (run) {
            runInstuctions(scope);
            toEvaluate.run(scope);
            run = toEvaluate.getIntValue() != 0;
        }
    }

    private void runInstuctions(Scope scope) {
        for (int i = 0; i < instructions.length; i++) {
            instructions[i].run(scope);
        }
    }

}
