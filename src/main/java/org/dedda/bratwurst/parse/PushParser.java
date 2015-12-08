package org.dedda.bratwurst.parse;

import org.dedda.bratwurst.lang.BWExpression;
import org.dedda.bratwurst.lang.Push;

/**
 * Created by dedda on 12/8/15.
 *
 * @author dedda
 */
public class PushParser extends InstructionParser {

    public Push parse(String line, int linenumber) {
        if (line.matches(Patterns.PUSH)) {
            String expression = line.substring(1, line.length() - 1);
            BWExpression argument = new ExpressionParser().parse(expression, linenumber);
            return new Push(linenumber, argument);
        }
        return null;
    }

}
