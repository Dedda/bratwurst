package org.dedda.bratwurst.parse;

import org.dedda.bratwurst.BratwurtstTestcase;
import org.dedda.bratwurst.lang.Exit;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;

/**
 * Created by dedda on 10/16/15.
 *
 * @author dedda
 */
public class ExitParserTest extends BratwurtstTestcase {

    @Test
    public void testParse() throws Exception {
        assertEquals(Exit.class, new ExitParser().parse("<==", 0).getClass());
        assertNull(new ExitParser().parse("==>", 0));
    }
}