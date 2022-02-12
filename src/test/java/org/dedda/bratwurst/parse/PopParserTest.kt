package org.dedda.bratwurst.parse

import org.dedda.bratwurst.BratwurtstTestcase
import org.testng.Assert
import org.testng.annotations.Test

/**
 * Created by dedda on 12/8/15.
 *
 * @author dedda
 */
class PopParserTest : BratwurtstTestcase() {
    @Test
    @Throws(Exception::class)
    fun testParse() {
        val variableName = "testPopVar"
        val line = "<$variableName<"
        val lineNumber = 15
        val parser = PopParser()
        val pop = parser.parse(line, lineNumber)
        Assert.assertEquals(variableName, pop!!.variableName)
        Assert.assertEquals(lineNumber, pop.lineNumber)
    }
}