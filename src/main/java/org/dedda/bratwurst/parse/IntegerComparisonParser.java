package org.dedda.bratwurst.parse;

import org.dedda.bratwurst.lang.IntegerComparison;

/**
 * Created by dedda on 1/28/16.
 *
 * @author dedda
 */
public class IntegerComparisonParser extends ExpressionParser {

    @Override
    public IntegerComparison parse(String data, int lineNumber) {
        String[] split = data.split(" ");
        String varName1 = split[0];
        String varName2 = split[2];
        IntegerComparison comparison = new IntegerComparison(lineNumber, varName1, varName2);
        return comparison;
    }
}
