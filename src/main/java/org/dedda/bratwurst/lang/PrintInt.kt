package org.dedda.bratwurst.lang

import org.dedda.bratwurst.lang.scope.Scope

/**
 * Created by dedda on 10/19/15.
 *
 * @author dedda
 */
class PrintInt(lineNumber: Int, private val message: String) : BWInstruction(lineNumber) {

    override fun run(scope: Scope) {
        if (message.matches(Regex("-?\\d+"))) {
            print(message)
        } else {
            val variable = scope.getVariable(message)
            print(variable.intValue)
        }
    }
}