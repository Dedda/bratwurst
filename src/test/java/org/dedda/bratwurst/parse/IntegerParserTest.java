package org.dedda.bratwurst.parse;

import org.dedda.bratwurst.BratwurtstTestcase;
import org.dedda.bratwurst.lang.BWInteger;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Collection;

import static org.testng.Assert.assertEquals;

/**
 * Created by dedda on 10/17/15.
 *
 * @author dedda
 */
public class IntegerParserTest extends BratwurtstTestcase {

    private IntegerParser parser;

    // TODO: Fix params
    public static Collection<Object[]> getParams() {
        return Arrays.asList(new Object[][]{
                {"0", 0},
                {"10", 10},
                {"-12345", -12345}
        });
    }

    public String data;

    public int expectedValue;

    public void setUp() throws Exception {
        parser = new IntegerParser();
    }

    @Test
    public void testParse() throws Exception {
        BWInteger integer = parser.parse(data, 0);
        assertEquals(expectedValue, integer.getIntValue());
    }
}