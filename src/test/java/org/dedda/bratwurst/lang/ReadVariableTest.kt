package org.dedda.bratwurst.lang

import org.dedda.bratwurst.lang.scope.Scope
import org.testng.Assert
import org.testng.annotations.BeforeMethod
import org.testng.annotations.Test

/**
 * Created by dedda on 12/17/15.
 *
 * @author dedda
 */
class ReadVariableTest {
    private lateinit var scope: Scope

    @BeforeMethod
    @Throws(Exception::class)
    fun setUp() {
        val program = Program()
        scope = Scope(program)
        scope.setVariable(BWVariable("abc", BWInteger(123)))
    }

    @Test
    @Throws(Exception::class)
    fun testRun() {
        val readVariable = ReadVariable(0, "abc")
        readVariable.run(scope)
        val variable = readVariable.value
        Assert.assertEquals(123, variable.intValue)
    }
}