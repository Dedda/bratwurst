package org.dedda.bratwurst.parse;

import org.dedda.bratwurst.lang.BWExpression;
import org.dedda.bratwurst.lang.StringGetChar;

/**
 * Created by dedda on 1/25/16.
 *
 * @author dedda
 */
public class StringGetCharParser extends ExpressionParser {

    @Override
    public StringGetChar parse(String data, int lineNumber) {
        String[] split = data.split("\\}");
        String varName = split[0].substring(1);
        String location = split[1].substring(0, split[1].length() - 1);
        StringGetChar getChar = new StringGetChar(lineNumber, location, varName);
        return getChar;
    }
}
