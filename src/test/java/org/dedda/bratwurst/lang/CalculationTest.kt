package org.dedda.bratwurst.lang

import org.dedda.bratwurst.BratwurtstTestcase
import org.testng.Assert
import org.testng.annotations.Test

/**
 * Created by dedda on 10/16/15.
 *
 * @author dedda
 */
class CalculationTest : BratwurtstTestcase() {
    @Test
    @Throws(Exception::class)
    fun testRun() {
        val int1 = BWInteger(10)
        val int2 = BWInteger(2)
        var calculation = Calculation(0, int1, int2, '+')
        calculation.run(null)
        Assert.assertEquals(12, calculation.intValue)
        calculation = Calculation(0, int1, int2, '-')
        calculation.run(null)
        Assert.assertEquals(8, calculation.intValue)
        calculation = Calculation(0, int1, int2, '*')
        calculation.run(null)
        Assert.assertEquals(20, calculation.intValue)
        calculation = Calculation(0, int1, int2, '/')
        calculation.run(null)
        Assert.assertEquals(5, calculation.intValue)
    }

    @Test
    @Throws(Exception::class)
    fun testGetIntValue() {
        val calculation = Calculation(0, BWInteger(1), BWInteger(2), '+')
        calculation.run(null)
        Assert.assertEquals(3, calculation.intValue)
    }

    @Test
    @Throws(Exception::class)
    fun testGetValue() {
        val calculation = Calculation(0, BWInteger(1), BWInteger(2), '+')
        calculation.run(null)
        Assert.assertEquals("integer", calculation.value.valueType)
        Assert.assertEquals(3, calculation.value.intValue)
    }

    @Test
    @Throws(Exception::class)
    fun testGetValueType() {
        Assert.assertEquals("integer", Calculation(0, null, null, '+').valueType)
    }
}