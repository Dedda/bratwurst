package org.dedda.bratwurst.lang

import org.dedda.bratwurst.lang.scope.Scope

/**
 * Created by dedda on 12/8/15.
 *
 * @author dedda
 */
class Pop(lineNumber: Int, val variableName: String) : BWInstruction(lineNumber) {
    override fun run(scope: Scope) {
        val value: BWExpression = scope.pop()
        val variable = BWVariable(variableName, value)
        variable.run(scope)
        scope.setVariable(variable)
    }

}