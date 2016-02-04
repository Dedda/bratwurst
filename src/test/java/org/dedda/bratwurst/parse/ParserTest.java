package org.dedda.bratwurst.parse;

import org.dedda.bratwurst.BratwurtstTestcase;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by dedda on 10/21/15.
 *
 * @author dedda
 */
public class ParserTest extends BratwurtstTestcase {

    @Test
    public void testInsertIntoArray() throws Exception {
        String[] array = new String[]{
                "==>",
                "|65|",
                "%include%",
                "|67|",
                "<=="
        };
        String[] toInsert = new String[]{
                "|1|",
                "|2|",
                "|3|"
        };
        String[] expected = new String[]{
                "==>",
                "|65|",
                "|1|",
                "|2|",
                "|3|",
                "|67|",
                "<=="
        };
        int index = 2;
        Parser parser = new Parser(null);
        String[] actual = parser.insertIntoArray(array, toInsert, index);
        assertEquals(expected.length, actual.length);
        for (int i = 0; i < actual.length; i++) {
            assertEquals(expected[i], actual[i]);
        }
    }
}