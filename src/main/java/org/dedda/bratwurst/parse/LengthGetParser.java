package org.dedda.bratwurst.parse;

import org.dedda.bratwurst.lang.LengthGet;

/**
 * Created by dedda on 1/25/16.
 *
 * @author dedda
 */
public class LengthGetParser extends ExpressionParser {

    @Override
    public LengthGet parse(String data, int lineNumber) {
        String varName = data.substring(2, data.length() - 2);
        return new LengthGet(lineNumber, varName);
    }
}
