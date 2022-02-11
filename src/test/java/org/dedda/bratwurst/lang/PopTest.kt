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
class PopTest {
    private lateinit var scope: Scope

    @BeforeMethod
    @Throws(Exception::class)
    fun setUp() {
        val `object`: BWObject
        `object` = BWInteger(312)
        val program = Program()
        program.push(`object`)
        scope = Scope(program)
    }

    @Test
    @Throws(Exception::class)
    fun testRun() {
        val pop = Pop(0, "abc")
        pop.run(scope)
        val variable = scope.getVariable("abc")
        Assert.assertEquals(312, variable.intValue)
    }
}