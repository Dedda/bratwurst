package org.dedda.bratwurst.parse

import org.dedda.bratwurst.BratwurtstTestcase
import org.dedda.bratwurst.lang.Exit
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
        Assert.assertEquals(Exit::class.java, ExitParser().parse("<==", 0).javaClass)
        Assert.assertNull(ExitParser().parse("==>", 0))
    }
}