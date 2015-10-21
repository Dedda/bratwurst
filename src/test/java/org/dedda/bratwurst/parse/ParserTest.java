package org.dedda.bratwurst.parse;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by dedda on 10/21/15.
 *
 * @author dedda
 */
public class ParserTest {

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
        assertEquals(expected, actual);
    }
}