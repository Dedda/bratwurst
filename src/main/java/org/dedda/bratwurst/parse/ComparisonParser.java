package org.dedda.bratwurst.parse;

import org.dedda.bratwurst.lang.Comparison;

/**
 * Created by dedda on 1/28/16.
 *
 * @author dedda
 */
public class ComparisonParser extends ExpressionParser {

    @Override
    public Comparison parse(String data, int lineNumber) {
        String[] split = data.split(" ");
        String varName1 = split[0];
        String varName2 = split[2];
        return new Comparison(lineNumber, varName1, varName2);
    }
}
