package org.dedda.bratwurst.parse;

import org.dedda.bratwurst.lang.ReadVariable;

import static org.dedda.bratwurst.parse.Patterns.VARIABLE_NAME;

/**
 * Created by dedda on 10/17/15.
 *
 * @author dedda
 */
public class ReadVariableParser extends ExpressionParser {

    public ReadVariable parse(String data, int lineNumber) {
        data = data.trim();
        if (!data.matches(VARIABLE_NAME)) {
            throw new RuntimeException("\"" + data + "\" is not a valid variable name!");
        }
        return new ReadVariable(lineNumber, data);
    }

}
