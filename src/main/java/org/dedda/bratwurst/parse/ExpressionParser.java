package org.dedda.bratwurst.parse;

import org.dedda.bratwurst.lang.BWExpression;

/**
 * Created by dedda on 10/17/15.
 *
 * @author dedda
 */
public class ExpressionParser {

    public BWExpression parse(String data) {
        data = data.trim();
        if (data.matches("\\d*")) {
            return new IntegerParser().parse(data);
        }
        return null;
    }

}
