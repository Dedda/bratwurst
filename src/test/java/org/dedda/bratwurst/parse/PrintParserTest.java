package org.dedda.bratwurst.parse;

import org.dedda.bratwurst.BratwurtstTestcase;
import org.dedda.bratwurst.lang.BWInstruction;
import org.dedda.bratwurst.lang.PrintChar;
import org.dedda.bratwurst.lang.PrintVariable;
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

    // TODO: Fix params
    public static Collection<Object[]> getParams() {
        return Arrays.asList(new Object[][]{
                {PrintChar.class, 'A', ">A<"},
                {PrintChar.class, (char) 65, ">65<"},
                {PrintVariable.class, "testVar", ">testVar<"}
        });
    }

    public Class expectedClass;

    public Object expectedValue;

    public String line;

    @Test
    public void testParse() throws Exception {
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