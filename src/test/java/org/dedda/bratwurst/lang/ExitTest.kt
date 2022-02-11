package org.dedda.bratwurst.lang

import org.dedda.bratwurst.ScopedTestCase
import org.dedda.bratwurst.lang.scope.Scope
import org.testng.Assert
import org.testng.annotations.Test

/**
 * Created by dedda on 12/17/15.
 *
 * @author dedda
 */
class ExitTest : ScopedTestCase() {
    private lateinit var scope: Scope

    @Throws(Exception::class)
    public override fun setUp() {
        scope = createEmptyScope()
        scope.program?.run()
    }

    @Test
    @Throws(Exception::class)
    fun testRun() {
        val exit = Exit(0)
        Assert.assertFalse(scope.program.isStopped)
        exit.run(scope)
        Assert.assertTrue(scope.program.isStopped)
    }
}