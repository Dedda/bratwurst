package org.dedda.bratwurst.lang

import org.dedda.bratwurst.ScopedTestCase
import org.dedda.bratwurst.lang.scope.Scope
import org.testng.Assert
import org.testng.annotations.BeforeMethod
import org.testng.annotations.Test

/**
 * Created by dedda on 12/17/15.
 *
 * @author dedda
 */
class VariableDeclarationTest : ScopedTestCase() {
    private lateinit var scope: Scope

    @BeforeMethod
    @Throws(Exception::class)
    public override fun setUp() {
        scope = createEmptyScope()
    }

    @Test
    @Throws(Exception::class)
    fun testRun() {
        val declaration = VariableDeclaration(0, "abc", BWInteger(123))
        declaration.run(scope)
        Assert.assertEquals(123, scope.getVariable("abc").intValue)
    }
}