package org.dedda.bratwurst.parse;

import org.dedda.bratwurst.BratwurtstTestcase;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.dedda.bratwurst.parse.Emoji.*;
import static org.junit.Assert.*;

/**
 * Created by dedda on 10/17/15.
 *
 * @author dedda
 */
public class BWFunctionParserTest extends BratwurtstTestcase {

    private final String[] lines = new String[]{
            ALIEN,
            BOMB,
            "(CALL_ME_MAYBE) <-- testFunc",
            "test -->",
            FLEX,
            ALL_OK
    };
    private final int begin = 1;
    private final int end = 4;

    @Test
    public void testGetEndOfFunction() throws Exception {
        int end = new BWFunctionParser().getEndOfFunction(lines, begin);
        assertEquals(this.end, end);
    }
}