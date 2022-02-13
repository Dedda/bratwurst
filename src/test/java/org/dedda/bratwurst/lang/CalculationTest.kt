package org.dedda.bratwurst.lang

import org.dedda.bratwurst.BratwurtstTestcase
import org.dedda.bratwurst.lang.scope.Scope
import org.mockito.Mockito.mock
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
        calculation.run(mock(Scope::class.java))
        Assert.assertEquals(12, calculation.intValue)
        calculation = Calculation(0, int1, int2, '-')
        calculation.run(mock(Scope::class.java))
        Assert.assertEquals(8, calculation.intValue)
        calculation = Calculation(0, int1, int2, '*')
        calculation.run(mock(Scope::class.java))
        Assert.assertEquals(20, calculation.intValue)
        calculation = Calculation(0, int1, int2, '/')
        calculation.run(mock(Scope::class.java))
        Assert.assertEquals(5, calculation.intValue)
    }

    @Test
    @Throws(Exception::class)
    fun testGetIntValue() {
        val calculation = Calculation(0, BWInteger(1), BWInteger(2), '+')
        calculation.run(mock(Scope::class.java))
        Assert.assertEquals(3, calculation.intValue)
    }

    @Test
    @Throws(Exception::class)
    fun testGetValue() {
        val calculation = Calculation(0, BWInteger(1), BWInteger(2), '+')
        calculation.run(mock(Scope::class.java))
        Assert.assertEquals(ValueType.INTEGER, calculation.value.valueType)
        Assert.assertEquals(3, calculation.value.intValue)
    }

    @Test
    @Throws(Exception::class)
    fun testGetValueType() {
        Assert.assertEquals(ValueType.INTEGER, Calculation(0, BWInteger(1), BWInteger(1), '+').valueType)
    }
}