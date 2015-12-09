package org.dedda.bratwurst.parse;

import org.dedda.bratwurst.lang.BWInteger;

/**
 * Created by dedda on 10/17/15.
 *
 * @author dedda
 */
public class IntegerParser extends ExpressionParser {

    @Override
    public BWInteger parse(String data, int lineNumber) {
        data = data.trim();
        return new BWInteger(Integer.parseInt(data));
    }

}
