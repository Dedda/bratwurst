package org.dedda.bratwurst.parse;

import org.dedda.bratwurst.lang.BWInteger;
import org.dedda.bratwurst.lang.Push;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by dedda on 12/8/15.
 *
 * @author dedda
 */
public class PushParserTest {

    @Test
    public void testParse() throws Exception {
        int number = 123;
        String line = ">" + number + ">";
        int lineNumber = 12;
        PushParser parser = new PushParser();
        Push push = parser.parse(line, lineNumber);
        assertEquals(new BWInteger(number), push.getArgument());
        assertEquals(lineNumber, push.getLineNumber());
    }
}