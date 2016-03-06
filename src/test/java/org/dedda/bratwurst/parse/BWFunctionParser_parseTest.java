package org.dedda.bratwurst.parse;

import org.dedda.bratwurst.BratwurtstTestcase;
import org.dedda.bratwurst.lang.BWFunction;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Collection;

import static org.testng.Assert.assertEquals;

/**
 * Created by dedda on 10/17/15.
 *
 * @author dedda
 */
public class BWFunctionParser_parseTest extends BratwurtstTestcase {

    private BWFunctionParser parser;

    // TDOD: Fix params
    public static Collection<Object[]> getParams() {
        return Arrays.asList(new Object[][]{
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
        });
    }

    public String[] lines;

    public int begin;

    public String expectedErrorMessage;

    public String expectedName;

    public int expectedInstructionsCount;

    public void setUp() throws Exception {
        parser = new BWFunctionParser();
    }

    @Test
    public void testParse() throws Exception {
        BWFunction function = null;
        try {
            function = parser.parse(lines, begin);
        } catch (RuntimeException e) {
            assertEquals(expectedErrorMessage, e.getMessage());
        }
        if (function != null) {
            assertEquals(expectedName, function.getName());
            assertEquals(expectedInstructionsCount, function.getInstructions().length);
        }
    }
}