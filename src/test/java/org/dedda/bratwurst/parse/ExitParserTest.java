package org.dedda.bratwurst.parse;

import org.dedda.bratwurst.lang.Exit;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by dedda on 10/16/15.
 *
 * @author dedda
 */
public class ExitParserTest {

    @Test
    public void testParse() throws Exception {
        assertEquals(Exit.class, new ExitParser().parse("<==").getClass());
        assertNull(new ExitParser().parse("==>"));
    }
}