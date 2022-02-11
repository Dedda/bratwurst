package org.dedda.bratwurst.lang.assertions

import org.dedda.bratwurst.lang.BWInteger
import org.dedda.bratwurst.lang.scope.Scope
import org.dedda.bratwurst.test.AssertionError
import org.dedda.bratwurst.test.AssertionResult
import org.dedda.bratwurst.test.AssertionSuccess

/**
 * Created by dedda on 1/23/16.
 *
 * @author dedda
 */
class AssertFalse(lineNumber: Int, private val variableName: String) : Assertion(lineNumber) {

    override fun doAssertion(scope: Scope): AssertionResult {
        val variable = scope.getVariable(variableName)
        var message: String? = null
        if (variable.value !is BWInteger) {
            message = "variable is not a number!"
        } else if (variable.intValue != 0) {
            message = "variable is true (" + variable.intValue + ")!"
        }
        if (message != null) {
            message = "ERROR asserting variable is true --> $lineNumber: $message"
            return AssertionError(message)
        }
        return AssertionSuccess
    }

}