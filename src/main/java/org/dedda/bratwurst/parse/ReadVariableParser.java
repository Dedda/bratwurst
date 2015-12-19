package org.dedda.bratwurst.parse;

import org.dedda.bratwurst.lang.ReadVariable;

import static org.dedda.bratwurst.parse.Patterns.validVariableNameEmojis;

/**
 * Created by dedda on 10/17/15.
 *
 * @author dedda
 */
public class ReadVariableParser extends ExpressionParser {

    public ReadVariable parse(String data, int lineNumber) {
        data = data.trim();
        if (!new StringValidator().isValid(data, validVariableNameEmojis())) {
            throw new RuntimeException("\"" + data + "\" is not a valid variable name!");
        }
        return new ReadVariable(lineNumber, data);
    }

}
