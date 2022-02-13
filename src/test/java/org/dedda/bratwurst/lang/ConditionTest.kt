package org.dedda.bratwurst.lang

import org.dedda.bratwurst.BratwurtstTestcase
import org.dedda.bratwurst.lang.scope.Scope
import org.mockito.Mockito
import org.testng.Assert
import org.testng.annotations.Test

/**
 * Created by dedda on 10/16/15.
 *
 * @author dedda
 */
class ConditionTest : BratwurtstTestcase() {

    private var trueRun = false
    private var falseRun = false
    private var testValue = 0
    private var condition: Condition? = null

    @Throws(Exception::class)
    public override fun setUp() {
        val trueInstructions = listOf<BWInstruction>(
            object : BWInstruction(0) {
                override fun run(scope: Scope) {
                    trueRun = true
                }
            }
        )
        val falseInstructions = listOf<BWInstruction>(
            object : BWInstruction(0) {
                override fun run(scope: Scope) {
                    falseRun = true
                }
            }
        )
        val expression: BWExpression = object : BWInteger(0) {
            override fun getIntValue(): Int {
                return testValue
            }
        }
        condition = Condition(0, expression, trueInstructions, falseInstructions)
    }

    @Test
    fun testRunTrue() {
        trueRun = false
        falseRun = false
        testValue = 1
        condition!!.run(Mockito.mock(Scope::class.java))
        Assert.assertTrue(trueRun)
        Assert.assertFalse(falseRun)
    }

    @Test
    fun testRunFalse() {
        trueRun = false
        falseRun = false
        testValue = 0
        condition!!.run(Mockito.mock(Scope::class.java))
        Assert.assertFalse(trueRun)
        Assert.assertTrue(falseRun)
    }
}