package org.dedda.bratwurst.parse

import org.dedda.bratwurst.BratwurtstTestcase
import org.dedda.bratwurst.lang.BWInteger
import org.testng.Assert
import org.testng.annotations.Test

/**
 * Created by dedda on 12/8/15.
 *
 * @author dedda
 */
class PushParserTest : BratwurtstTestcase() {
    @Test
    fun testParse() {
        val number = 123
        val line = ">$number>"
        val lineNumber = 12
        val parser = PushParser()
        val push = parser.parse(line, lineNumber)
        Assert.assertEquals(BWInteger(number), push!!.argument)
        Assert.assertEquals(lineNumber, push.lineNumber)
    }
}