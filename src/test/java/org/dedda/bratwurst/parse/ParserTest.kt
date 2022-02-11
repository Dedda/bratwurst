package org.dedda.bratwurst.parse

import org.dedda.bratwurst.BratwurtstTestcase
import org.testng.Assert
import org.testng.annotations.Test

/**
 * Created by dedda on 10/21/15.
 *
 * @author dedda
 */
class ParserTest : BratwurtstTestcase() {
    @Test
    @Throws(Exception::class)
    fun testInsertIntoArray() {
        val array = arrayOf(
                "==>",
                "|65|",
                "%include%",
                "|67|",
                "<=="
        )
        val toInsert = arrayOf(
                "|1|",
                "|2|",
                "|3|"
        )
        val expected = arrayOf(
                "==>",
                "|65|",
                "|1|",
                "|2|",
                "|3|",
                "|67|",
                "<=="
        )
        val index = 2
        val parser = Parser(null)
        val actual = parser.insertIntoArray(array, toInsert, index)
        Assert.assertEquals(expected.size, actual.size)
        for (i in actual.indices) {
            Assert.assertEquals(expected[i], actual[i])
        }
    }
}