package org.dedda.bratwurst.parse;

import org.dedda.bratwurst.lang.CharToInt;

/**
 * Created by dedda on 1/28/16.
 *
 * @author dedda
 */
public class CharToIntParser extends ExpressionParser {

    @Override
    public CharToInt parse(String data, int lineNumber) {
        String varname = data.split(" ")[1];
        return new CharToInt(lineNumber, varname);
    }
}
