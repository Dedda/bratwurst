package org.dedda.bratwurst.parse

import org.dedda.bratwurst.BratwurtstTestcase
import org.testng.Assert
import org.testng.annotations.Test

/**
 * Created by dedda on 12/9/15.
 *
 * @author dedda
 */
class InstanceofParserTest : BratwurtstTestcase() {
    @Test
    @Throws(Exception::class)
    fun testParse() {
        val line = "testVar -?> testClass"
        val parser = InstanceofParser()
        val instruction = parser.parse(line, 0)
        Assert.assertEquals("testClass", instruction.className)
    }
}