package org.dedda.bratwurst.lang

import org.dedda.bratwurst.lang.scope.Scope

/**
 * Created by dedda on 10/14/15.
 *
 * @author dedda
 */
class PrintChar(lineNumber: Int, val toPrint: Char) : BWInstruction(lineNumber) {

    override fun run(scope: Scope) {
        print(toPrint)
    }
}