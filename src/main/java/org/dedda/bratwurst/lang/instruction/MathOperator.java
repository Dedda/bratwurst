package org.dedda.bratwurst.lang.instruction;

import org.dedda.bratwurst.lang.object.BWObject;

/**
 * Created by dedda on 9/28/15.
 *
 * @author dedda
 */
public class MathOperator {

    private char operator;

    public MathOperator(char operator) {
        this.operator = operator;
    }

    public BWObject apply(final BWObject left, final BWObject right) {
        if (!(left.getBwClass().getName().equals("integer") && right.getBwClass().getName().equals("integer"))) {
            return null;
        }
        return null;
    }

}
