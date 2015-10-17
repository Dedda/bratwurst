package org.dedda.bratwurst.parse;

import org.dedda.bratwurst.lang.BWInteger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

/**
 * Created by dedda on 10/17/15.
 *
 * @author dedda
 */
@RunWith(Parameterized.class)
public class IntegerParserTest {

    private IntegerParser parser;

    @Parameters
    public static Collection<Object[]> getParams() {
        return Arrays.asList(new Object[][]{
                {"0", 0},
                {"10", 10},
                {"12345", 12345}
        });
    }

    @Parameter(0)
    public String data;

    @Parameter(1)
    public int expectedValue;

    @Before
    public void setUp() throws Exception {
        parser = new IntegerParser();
    }

    @Test
    public void testParse() throws Exception {
        BWInteger integer = parser.parse(data);
        assertEquals(expectedValue, integer.getIntValue());
    }
}