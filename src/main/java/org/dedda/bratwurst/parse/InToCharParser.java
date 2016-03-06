package org.dedda.bratwurst.parse;

import org.dedda.bratwurst.lang.IntToChar;

/**
 * Created by dedda on 1/28/16.
 *
 * @author dedda
 */
public class InToCharParser extends ExpressionParser {

    @Override
    public IntToChar parse(String data, int lineNumber) {
        String varname = data.split(" ")[1];
        return new IntToChar(lineNumber, varname);
    }
}
