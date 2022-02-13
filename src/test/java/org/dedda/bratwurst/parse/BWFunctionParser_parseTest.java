package org.dedda.bratwurst.parse;

import org.dedda.bratwurst.BratwurtstTestcase;
import org.dedda.bratwurst.lang.BWFunction;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;

import static org.testng.Assert.assertEquals;

/**
 * Created by dedda on 10/17/15.
 *
 * @author dedda
 */
public class BWFunctionParser_parseTest extends BratwurtstTestcase {

    private BWFunctionParser parser;

    // TDOD: Fix params
    @DataProvider
    public static Object[][] getParams() {
        return new Object[][]{
                {new String[]{
                        "==>",
                        "~{",
                        "(CALL_ME_MAYBE) <-- testFunc",
                        "test -->",
                        "}",
                        "<=="
                }, 1, null, "testFunc", 1},
                {new String[]{
                        "==>",
                        "~{",
                        "test -->",
                        "}",
                        "<=="
                }, 1, "function name not defined!", null, 0},
                {new String[]{
                        "==>",
                        "~{",
                        "}",
                        "<=="
                }, 0, "invalid function begin, no head found!", null, 0},
                {new String[]{
                        "==>",
                        "~{",
                        "test -->",
                        "<=="
                }, 1, "End of method not found!", null, 0}
        };
    }

    public void setUp() throws Exception {
        parser = new BWFunctionParser();
    }

    @Test(dataProvider = "getParams")
    public void testParse(final String[] lines, final int begin, final String expectedErrorMessage, final String expectedName, final int expectedInstructionsCount) {
        BWFunction function = null;
        try {
            function = parser.parse(Arrays.asList(lines), begin);
        } catch (RuntimeException e) {
            assertEquals(expectedErrorMessage, e.getMessage());
        }
        if (function != null) {
            assertEquals(expectedName, function.getName());
            assertEquals(expectedInstructionsCount, function.getInstructions().size());
        }
    }
}