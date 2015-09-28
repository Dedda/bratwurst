package org.dedda.bratwurst.parse;

import org.dedda.bratwurst.lang.instruction.Print;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by dedda on 9/28/15.
 *
 * @author dedda
 */
public class PrintParserTest {

    @Test
    public void testParse() throws Exception {
        String message = "Test text with numbers 123 and special characters !@)&&@";
        String line = ">" + message + "<";
        Print print = new PrintParser().parse(line);
        assertEquals(message, print.message);
    }
}