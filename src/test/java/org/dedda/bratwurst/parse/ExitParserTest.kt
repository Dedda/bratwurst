package org.dedda.bratwurst.parse

import org.dedda.bratwurst.BratwurtstTestcase
import org.testng.Assert
import org.testng.annotations.Test

/**
 * Created by dedda on 10/16/15.
 *
 * @author dedda
 */
class ExitParserTest : BratwurtstTestcase() {
    @Test
    @Throws(Exception::class)
    fun testParse() {
        Assert.assertNotNull(ExitParser().parse("<==", 0))
        Assert.assertNull(ExitParser().parse("==>", 0))
    }
}