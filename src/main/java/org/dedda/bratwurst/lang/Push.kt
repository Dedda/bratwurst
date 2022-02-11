package org.dedda.bratwurst.lang

import org.dedda.bratwurst.lang.scope.Scope

/**
 * Created by dedda on 12/8/15.
 *
 * @author dedda
 */
class Push(lineNumber: Int, val argument: BWExpression) : BWInstruction(lineNumber) {
    override fun run(scope: Scope) {
        argument.run(scope)
        scope.push(argument.value)
    }

}