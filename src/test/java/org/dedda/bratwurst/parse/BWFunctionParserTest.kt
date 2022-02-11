package org.dedda.bratwurst.parse

import org.dedda.bratwurst.BratwurtstTestcase
import org.testng.Assert
import org.testng.annotations.Test

/**
 * Created by dedda on 10/17/15.
 *
 * @author dedda
 */
class BWFunctionParserTest : BratwurtstTestcase() {
    @Test
    @Throws(Exception::class)
    fun testGetEndOfFunction() {
        val lines = arrayOf(
                "==>",
                "~{",
                "(CALL_ME_MAYBE) <-- testFunc",
                "test -->",
                "}",
                "<=="
        )
        val begin = 1
        val expectedEnd = 4
        val end = BWFunctionParser().getEndOfFunction(lines, begin)
        Assert.assertEquals(expectedEnd, end)
    }
}