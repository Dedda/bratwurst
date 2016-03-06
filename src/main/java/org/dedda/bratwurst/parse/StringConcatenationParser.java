package org.dedda.bratwurst.parse;

import org.dedda.bratwurst.lang.StringConcatenation;

/**
 * Created by dedda on 1/25/16.
 *
 * @author dedda
 */
public class StringConcatenationParser extends ExpressionParser {

    @Override
    public StringConcatenation parse(String data, int lineNumber) {
        String[] split = data.split(" ");
        String[] varNames = new String[(split.length / 2 ) + 1];
        for (int i = 0; i < varNames.length; i++) {
            varNames[i] = split[i*2];
        }
        return new StringConcatenation(lineNumber, varNames);
    }
}
