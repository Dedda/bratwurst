package org.dedda.bratwurst.lang

import org.dedda.bratwurst.BratwurtstTestcase
import org.dedda.bratwurst.lang.scope.Scope
import org.testng.Assert
import org.testng.annotations.Test

/**
 * Created by dedda on 12/17/15.
 *
 * @author dedda
 */
class ObjectCreationTest : BratwurtstTestcase() {
    private lateinit var scope: Scope

    @Throws(Exception::class)
    public override fun setUp() {
        val program = Program()
        program.registerClass(BWClass("testClass", arrayOf()))
        scope = Scope(program)
    }

    @Test
    @Throws(Exception::class)
    fun testRun() {
        val objectCreation = ObjectCreation(0, "testClass")
        objectCreation.run(scope)
        val `object` = objectCreation.value
        Assert.assertEquals(ValueType.OBJECT, `object`.valueType)
        Assert.assertEquals("testClass", `object`.bwClass.name)
    }
}