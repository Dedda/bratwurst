package org.dedda.bratwurst.parse;

import org.dedda.bratwurst.lang.BWInstruction;
import org.dedda.bratwurst.lang.BWInteger;
import org.dedda.bratwurst.lang.Calculation;
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
public class CalculationParserTest {

    @Parameters
    public static Collection<Object[]> getParams() {
        return Arrays.asList(new Object[][]{
                {"123 + 456", '+', 123, 456},
                {"123 - 456", '-', 123, 456},
                {"123 * 456", '*', 123, 456},
                {"123 / 456", '/', 123, 456},
                {"123 + 456 * 789", '*', null, 789},
                {"123 / 456 * 789", '/', 123, null}
        });
    }

    @Parameter(0)
    public String line;

    @Parameter(1)
    public char expectedOperator;

    @Parameter(2)
    public Integer leftArgumentValue;

    @Parameter(3)
    public Integer rightArgumentValue;

    @Test
    public void testParse() throws Exception {
        CalculationParser parser = new CalculationParser();
        Calculation calculation = parser.parse(line, 0);
        assertEquals(expectedOperator, calculation.getOperator());
        if (leftArgumentValue != null) {
            assertEquals((int) leftArgumentValue, calculation.getLeftSide().getIntValue());
        }
        if (rightArgumentValue != null) {
            assertEquals((int) rightArgumentValue, calculation.getRightSide().getIntValue());
        }
    }
}