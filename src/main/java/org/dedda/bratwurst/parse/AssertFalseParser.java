package org.dedda.bratwurst.parse;

import org.dedda.bratwurst.lang.assertions.AssertEquals;
import org.dedda.bratwurst.lang.assertions.AssertFalse;
import org.dedda.bratwurst.lang.assertions.AssertTrue;

/**
 * Created by dedda on 1/23/16.
 *
 * @author dedda
 */
public class AssertFalseParser {

    public AssertFalse parse(String line, int lineNumber) {
        String varName = line.substring(3, line.length() - 2);
        return new AssertFalse(lineNumber, varName);
    }

}
