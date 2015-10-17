package org.dedda.bratwurst.parse;

import org.dedda.bratwurst.lang.Return;

/**
 * Created by dedda on 10/17/15.
 *
 * @author dedda
 */
public class ReturnParser {

    public Return parse(String line) {
        return new Return(new ExpressionParser().parse(line.substring(0, line.length()-4)));
    }

}
