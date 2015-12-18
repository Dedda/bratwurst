package org.dedda.bratwurst.parse;

import org.dedda.bratwurst.lang.BWExpression;
import org.dedda.bratwurst.lang.Push;

import static org.dedda.bratwurst.parse.Emoji.*;

/**
 * Created by dedda on 12/8/15.
 *
 * @author dedda
 */
public class PushParser extends InstructionParser {

    public Push parse(String line, int linenumber) {
        if (line.matches(Patterns.PUSH)) {
            String expression = line.substring(LEMON.length(), line.length() - SANTA.length());
            BWExpression argument = new ExpressionParser().parse(expression, linenumber);
            return new Push(linenumber, argument);
        }
        return null;
    }

}
