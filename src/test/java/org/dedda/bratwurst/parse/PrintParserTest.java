package org.dedda.bratwurst.parse;

import org.dedda.bratwurst.BratwurtstTestcase;
import org.dedda.bratwurst.lang.BWInstruction;
import org.dedda.bratwurst.lang.PrintChar;
import org.dedda.bratwurst.lang.PrintVariable;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Collection;

import static org.testng.Assert.assertEquals;

/**
 * Created by dedda on 10/15/15.
 *
 * @author dedda
 */
public class PrintParserTest extends BratwurtstTestcase {

    @DataProvider(name = "getParams")
    public static Object[][] getParams() {
        return new Object[][]{
                {PrintChar.class, 'A', ">A<"},
                {PrintChar.class, (char) 65, ">65<"},
                {PrintVariable.class, "testVar", ">testVar<"}
        };
    }

    @Test(dataProvider = "getParams")
    public void testParse(Class expectedClass, Object expectedValue, String line) throws Exception {
        PrintParser parser = new PrintParser();
        BWInstruction print = parser.parse(line, 0);
        assertEquals(expectedClass, print.getClass());
        if (print instanceof PrintChar) {
            assertEquals(expectedValue, ((PrintChar) print).getToPrint());
        } else if (print instanceof PrintVariable) {
            assertEquals(expectedValue, ((PrintVariable) print).getVariableName());
        }
    }

}