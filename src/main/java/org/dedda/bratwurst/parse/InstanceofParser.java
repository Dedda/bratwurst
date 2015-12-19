package org.dedda.bratwurst.parse;

import org.dedda.bratwurst.lang.BWExpression;
import org.dedda.bratwurst.lang.Instanceof;

import static org.dedda.bratwurst.parse.Emoji.CACTUS;

/**
 * Created by dedda on 12/9/15.
 *
 * @author dedda
 */
public class InstanceofParser extends ExpressionParser {

    @Override
    public Instanceof parse(final String line, final int lineNumber) {
        if (line.matches(Patterns.TYPE_CHECK)) {
            String parts[] = line.split(CACTUS);
            BWExpression expression = new ExpressionParser().parse(parts[0], lineNumber);
            String className = parts[1];
            return new Instanceof(lineNumber, expression, className);
        }
        return null;
    }

}
