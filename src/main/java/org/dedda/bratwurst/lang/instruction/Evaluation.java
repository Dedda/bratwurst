package org.dedda.bratwurst.lang.instruction;

import org.dedda.bratwurst.lang.BWExpression;
import org.dedda.bratwurst.lang.object.BWObject;

/**
 * Created by dedda on 9/28/15.
 *
 * @author dedda
 */
public class Evaluation {

    private BWExpression[] expressions;
    private MathOperator[] mathOperators;

    public Evaluation(BWExpression[] expressions, MathOperator[] mathOperators) {
        if (expressions.length != mathOperators.length+1) {
            throw new RuntimeException("Wrong number of arguments");
        }
        this.expressions = expressions;
        this.mathOperators = mathOperators;
    }

    public BWObject run() {
        BWObject buffer = expressions[0].getValue();
        for (int i = 0; i < mathOperators.length; i++) {
            buffer = mathOperators[i].apply(buffer, expressions[i+1].getValue());
        }
        return buffer;
    }
}
