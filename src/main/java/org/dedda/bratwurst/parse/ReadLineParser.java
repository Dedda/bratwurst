package org.dedda.bratwurst.parse;

import org.dedda.bratwurst.lang.io.terminal.ReadLine;

/**
 * Created by dedda on 1/28/16.
 *
 * @author dedda
 */
public class ReadLineParser extends ExpressionParser {

    @Override
    public ReadLine parse(String data, int lineNumber) {
        return new ReadLine(lineNumber);
    }
}
