package org.dedda.bratwurst.parse;

import org.dedda.bratwurst.lang.assertions.AssertEquals;

/**
 * Created by dedda on 1/23/16.
 *
 * @author dedda
 */
public class AssertEqualsParser {

    public AssertEquals parse(String line, int lineNumber) {
        String[] split =  line.split(" ");
        String varName1 = split[0].substring(2);
        String varName2 = split[2].substring(0, split[2].length() - 2);
        return new AssertEquals(lineNumber, varName1, varName2);
    }

}
