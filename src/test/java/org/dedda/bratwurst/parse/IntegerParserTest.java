package org.dedda.bratwurst.parse;

import org.dedda.bratwurst.BratwurtstTestcase;
import org.dedda.bratwurst.lang.BWInteger;
import org.testng.annotations.DataProvider;
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

    // TODO: Fix params
    @DataProvider(name = "getParams")
    public static Object[][] getParams() {
        return new Object[][]{
                {"0", 0},
                {"10", 10},
                {"-12345", -12345}
        };
    }

    @Test(dataProvider = "getParams")
    public void testParse(String data, int expectedValue) throws Exception {
        IntegerParser parser = new IntegerParser();
        BWInteger integer = parser.parse(data, 0);
        assertEquals(expectedValue, integer.getIntValue());
    }
}