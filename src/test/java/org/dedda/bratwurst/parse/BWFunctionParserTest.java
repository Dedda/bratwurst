package org.dedda.bratwurst.parse;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by dedda on 10/17/15.
 *
 * @author dedda
 */
public class BWFunctionParserTest {

    private final String[] lines = new String[]{
            "==>",
            "~{",
            "(CALL_ME_MAYBE) <-- testFunc",
            "test -->",
            "}",
            "<=="
    };
    private final int begin = 1;
    private final int end = 4;

    @Test
    public void testGetEndOfFunction() throws Exception {
        int end = new BWFunctionParser().getEndOfFunction(lines, begin);
        assertEquals(this.end, end);
    }
}