package org.dedda.bratwurst.parse;

import org.dedda.bratwurst.BratwurtstTestcase;
import org.dedda.bratwurst.lang.BWInstruction;
import org.dedda.bratwurst.lang.PrintChar;
import org.dedda.bratwurst.lang.PrintVariable;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.dedda.bratwurst.parse.Emoji.*;
import static org.junit.Assert.assertEquals;

/**
 * Created by dedda on 10/15/15.
 *
 * @author dedda
 */
@RunWith(Parameterized.class)
public class PrintParserTest extends BratwurtstTestcase {

    @Parameters
    public static Collection<Object[]> getParams() {
        return Arrays.asList(new Object[][]{
                {PrintChar.class, 'A', SNAKE + "A" + TURBAN},
                {PrintChar.class, (char) 65, SNAKE + "65" + TURBAN},
                {PrintVariable.class, "testVar", SNAKE + "testVar" + TURBAN}
        });
    }

    @Parameter(0)
    public Class expectedClass;

    @Parameter(1)
    public Object expectedValue;

    @Parameter(2)
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