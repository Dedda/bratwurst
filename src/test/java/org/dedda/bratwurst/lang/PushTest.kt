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
class PushTest {
    private lateinit var scope: Scope

    @BeforeMethod
    @Throws(Exception::class)
    fun setUp() {
        val program = Program()
        scope = Scope(program)
    }

    @Test
    @Throws(Exception::class)
    fun testRun() {
        val expression: BWObject = BWInteger(123)
        val push = Push(0, expression)
        push.run(scope)
        Assert.assertEquals(expression, scope.program.pop())
    }
}