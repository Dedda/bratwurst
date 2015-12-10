package org.dedda.bratwurst.parse;

import org.dedda.bratwurst.BratwurtstTestcase;
import org.dedda.bratwurst.lang.BWFunction;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Created by dedda on 10/17/15.
 *
 * @author dedda
 */
@RunWith(Parameterized.class)
public class BWFunctionParser_parseTest extends BratwurtstTestcase {

    private BWFunctionParser parser;

    @Parameters
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

    @Parameter(0)
    public String[] lines;

    @Parameter(1)
    public int begin;

    @Parameter(2)
    public String expectedErrorMessage;

    @Parameter(3)
    public String expectedName;

    @Parameter(4)
    public int expectedInstructionsCount;

    @Before
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