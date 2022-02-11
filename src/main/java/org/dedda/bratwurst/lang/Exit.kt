package org.dedda.bratwurst.lang

import org.dedda.bratwurst.lang.scope.Scope

/**
 * Created by dedda on 10/14/15.
 *
 * @author dedda
 */
class Exit(lineNumber: Int) : BWInstruction(lineNumber) {
    override fun run(scope: Scope) {
        scope.program.stop(0)
    }
}