package org.dedda.bratwurst.lang

import org.dedda.bratwurst.ScopedTestCase
import org.dedda.bratwurst.lang.scope.Scope
import org.testng.Assert
import org.testng.AssertJUnit
import org.testng.annotations.DataProvider
import org.testng.annotations.Test
import java.util.*

/**
 * Created by dedda on 10/16/15.
 *
 * @author dedda
 */
class BWFunctionTest : ScopedTestCase() {

    @get:DataProvider(name = "getParams")
    val params: Array<Array<Any>>
        get() = arrayOf(
            arrayOf(
                listOf(
                    object : BWInstruction(0) {
                        override fun run(scope: Scope) {
                            executed[0] = true
                        }
                    },
                    object : BWInstruction(0) {
                        override fun run(scope: Scope) {
                            executed[1] = true
                        }
                    }
                ),
                BWInteger(0),
                arrayOfNulls<BWVariable>(0)
            ),
            arrayOf(
                listOf(
                    object : BWInstruction(0) {
                        override fun run(scope: Scope) {
                            executed[0] = true
                        }
                    }, Return(0, object : BWInteger(1) {
                        override fun run(scope: Scope) {
                            super.run(scope)
                            executed[1] = true
                        }
                    })
                ),
                BWInteger(1),
                arrayOfNulls<BWVariable>(0)
            )
        )

    @Test(dataProvider = "getParams")
    @Throws(Exception::class)
    fun testFunction(instructions: List<BWInstruction>, expectedValue: BWObject, arguments: Array<BWVariable>) {
        val function = BWFunction("testFunction", instructions)
        executed = BooleanArray(instructions.size)
        Arrays.fill(executed, false)
        function.arguments = arguments
        function.run(createEmptyScope())
        Assert.assertEquals(expectedValue.valueType, function.valueType)
        Assert.assertEquals(expectedValue.intValue, function.intValue)
        for (i in executed.indices) {
            val isExecuted = executed[i]
            AssertJUnit.assertTrue("instruction $i wan't executed!", isExecuted)
        }
    }

    companion object {
        private var executed: BooleanArray = BooleanArray(0)
    }
}