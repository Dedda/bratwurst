package org.dedda.bratwurst.parse;

import org.dedda.bratwurst.BratwurtstTestcase;
import org.dedda.bratwurst.lang.Instanceof;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created by dedda on 12/9/15.
 *
 * @author dedda
 */
public class InstanceofParserTest extends BratwurtstTestcase {

    @Test
    public void testParse() throws Exception {
        String line = "testVar -?> testClass";
        InstanceofParser parser = new InstanceofParser();
        Instanceof instruction = parser.parse(line, 0);
        assertEquals("testClass", instruction.className);
    }
}