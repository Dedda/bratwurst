package org.dedda.bratwurst.parse;

import org.dedda.bratwurst.BratwurtstTestcase;
import org.dedda.bratwurst.lang.Calculation;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Collection;

import static org.testng.Assert.assertEquals;

/**
 * Created by dedda on 10/17/15.
 *
 * @author dedda
 */
public class CalculationParserTest extends BratwurtstTestcase {

    // TODO: FIx params
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

    public String line;

    public char expectedOperator;

    public Integer leftArgumentValue;

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