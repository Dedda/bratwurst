package org.dedda.bratwurst.parse;

import org.dedda.bratwurst.BratwurtstTestcase;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created by dedda on 10/17/15.
 *
 * @author dedda
 */
public class BWFunctionParserTest extends BratwurtstTestcase {

    @Test
    public void testGetEndOfFunction() throws Exception {
        final String[] lines = new String[]{
                "==>",
                "~{",
                "(CALL_ME_MAYBE) <-- testFunc",
                "test -->",
                "}",
                "<=="
        };
        final int begin = 1;
        final int expectedEnd = 4;
        int end = new BWFunctionParser().getEndOfFunction(lines, begin);
        assertEquals(expectedEnd, end);
    }
}