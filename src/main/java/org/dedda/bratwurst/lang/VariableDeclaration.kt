package org.dedda.bratwurst.lang

import org.dedda.bratwurst.lang.scope.Scope

/**
 * Created by dedda on 10/15/15.
 *
 * @author dedda
 */
class VariableDeclaration(lineNumber: Int, val variableName: String, private val targetValue: BWExpression) : BWInstruction(lineNumber) {
    override fun run(scope: Scope) {
        targetValue.run(scope)
        val value = targetValue.value
        val variable = BWVariable(variableName, value)
        scope.setVariable(variable)
    }

}