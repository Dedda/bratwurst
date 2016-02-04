package org.dedda.bratwurst.parse;

import org.dedda.bratwurst.lang.assertions.AssertTrue;

/**
 * Created by dedda on 1/23/16.
 *
 * @author dedda
 */
public class AssertTrueParser {

    public AssertTrue parse(String line, int lineNumber) {
        String varName = line.substring(2, line.length() - 2);
        return new AssertTrue(lineNumber, varName);
    }

}
