package org.dedda.bratwurst.parse;

import org.dedda.bratwurst.BratwurtstTestcase;
import org.dedda.bratwurst.lang.Exit;
import org.junit.Test;

import static org.dedda.bratwurst.parse.Emoji.ALIEN;
import static org.dedda.bratwurst.parse.Emoji.ALL_OK;
import static org.junit.Assert.*;

/**
 * Created by dedda on 10/16/15.
 *
 * @author dedda
 */
public class ExitParserTest extends BratwurtstTestcase {

    @Test
    public void testParse() throws Exception {
        assertEquals(Exit.class, new ExitParser().parse(ALL_OK, 0).getClass());
        assertNull(new ExitParser().parse(ALIEN, 0));
    }
}