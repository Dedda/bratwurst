package org.dedda.bratwurst.parse;

import org.dedda.bratwurst.lang.Return;

/**
 * Created by dedda on 10/17/15.
 *
 * @author dedda
 */
public class ReturnParser extends InstructionParser {

    public Return parse(String line, int lineNumber) {
        return new Return(lineNumber, new ExpressionParser().parse(line.trim().substring(0, line.length()-4).trim(), lineNumber));
    }

}
