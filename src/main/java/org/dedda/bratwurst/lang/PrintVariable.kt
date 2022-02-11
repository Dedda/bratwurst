package org.dedda.bratwurst.lang

import org.dedda.bratwurst.lang.scope.Scope

/**
 * Created by dedda on 10/14/15.
 *
 * @author dedda
 */
class PrintVariable(lineNumber: Int, val variableName: String) : BWInstruction(lineNumber) {
    override fun run(scope: Scope) {
        val variable = scope.getVariable(variableName)
        if (variable.value is BWString) {
            print((variable.value as BWString).stringValue)
        } else {
            val character = variable.intValue.toChar()
            print(character)
        }
    }

}