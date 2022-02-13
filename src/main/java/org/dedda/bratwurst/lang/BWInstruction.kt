package org.dedda.bratwurst.lang

import org.dedda.bratwurst.lang.scope.Scope

/**
 * Created by dedda on 10/14/15.
 *
 * @author dedda
 */
abstract class BWInstruction(val lineNumber: Int) {
    var arguments = emptyArray<BWVariable>()

    abstract fun run(scope: Scope)
}