package org.dedda.bratwurst

import org.dedda.bratwurst.lang.Program
import org.dedda.bratwurst.lang.scope.Scope

/**
 * Created by dedda on 1/24/16.
 *
 * @author dedda
 */
open class ScopedTestCase : BratwurtstTestcase() {
    protected fun createEmptyScope(): Scope {
        val program = Program()
        return Scope(program)
    }
}