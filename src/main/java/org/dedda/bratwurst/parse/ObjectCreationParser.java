package org.dedda.bratwurst.parse;

import org.dedda.bratwurst.lang.ObjectCreation;

/**
 * Created by dedda on 10/17/15.
 *
 * @author dedda
 */
public class ObjectCreationParser extends ExpressionParser {

    public ObjectCreation parse(String line, int lineNumber) {
        line = line.trim();
        return new ObjectCreation(lineNumber, line.substring(
                Patterns.CLASS_INSTANTIATION_OPEN.length(),
                line.length() - Patterns.CLASS_INSTANTIATION_CLOSE.length()
        ));
    }

}
