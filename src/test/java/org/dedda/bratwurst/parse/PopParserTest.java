package org.dedda.bratwurst.parse;

import org.dedda.bratwurst.BratwurtstTestcase;
import org.dedda.bratwurst.lang.Pop;
import org.junit.Test;

import static org.dedda.bratwurst.parse.Emoji.*;
import static org.junit.Assert.*;

/**
 * Created by dedda on 12/8/15.
 *
 * @author dedda
 */
public class PopParserTest extends BratwurtstTestcase {

    @Test
    public void testParse() throws Exception {
        String variableName = "testPopVar";
        String line = PINEAPPLE + variableName + MONKEY_FACE;
        int lineNumber = 15;
        PopParser parser = new PopParser();
        Pop pop = parser.parse(line, lineNumber);
        assertEquals(variableName, pop.getVariableName());
        assertEquals(lineNumber, pop.getLineNumber());
    }
}