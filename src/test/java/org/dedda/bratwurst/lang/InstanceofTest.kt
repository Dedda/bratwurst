package org.dedda.bratwurst.lang

import org.dedda.bratwurst.BratwurtstTestcase
import org.dedda.bratwurst.lang.classes.BWClass
import org.dedda.bratwurst.lang.scope.Scope
import org.mockito.Mockito.mock
import org.testng.Assert
import org.testng.annotations.Test

/**
 * Created by dedda on 12/9/15.
 *
 * @author dedda
 */
class InstanceofTest : BratwurtstTestcase() {
    @Test
    @Throws(Exception::class)
    fun testRun() {
        val integerType = "integer"
        val testType = "testClass"
        val testClass = BWClass("testClass", emptyArray())
        val integer = BWInteger(12)
        val testObject = BWObject(testClass)
        var instruction = Instanceof(0, integer, integerType)
        instruction.run(mock(Scope::class.java))
        Assert.assertEquals(BWInteger(1), instruction.value)
        instruction = Instanceof(0, integer, testType)
        instruction.run(mock(Scope::class.java))
        Assert.assertEquals(BWInteger(0), instruction.value)
        instruction = Instanceof(0, testObject, testType)
        instruction.run(mock(Scope::class.java))
        Assert.assertEquals(BWInteger(1), instruction.value)
        instruction = Instanceof(0, testObject, integerType)
        instruction.run(mock(Scope::class.java))
        Assert.assertEquals(BWInteger(0), instruction.value)
    }
}