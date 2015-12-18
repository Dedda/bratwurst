package org.dedda.bratwurst.parse;

import org.dedda.bratwurst.BratwurtstTestcase;
import org.dedda.bratwurst.lang.BWClass;
import org.dedda.bratwurst.lang.BWFunction;
import org.dedda.bratwurst.lang.BWInteger;
import org.dedda.bratwurst.lang.BWObject;
import org.dedda.bratwurst.lang.Instanceof;
import org.junit.Test;

import static org.dedda.bratwurst.parse.Emoji.CACTUS;
import static org.junit.Assert.*;

/**
 * Created by dedda on 12/9/15.
 *
 * @author dedda
 */
public class InstanceofParserTest extends BratwurtstTestcase {

    @Test
    public void testParse() throws Exception {
        String line = "testVar " + CACTUS + " testClass";
        InstanceofParser parser = new InstanceofParser();
        Instanceof instruction = parser.parse(line, 0);
        assertEquals("testClass", instruction.className);
    }
}