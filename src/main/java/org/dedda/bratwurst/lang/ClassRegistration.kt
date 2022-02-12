package org.dedda.bratwurst.lang

import org.dedda.bratwurst.lang.classes.BWClass
import org.dedda.bratwurst.lang.scope.Scope

/**
 * Created by dedda on 10/16/15.
 *
 * @author dedda
 */
class ClassRegistration(private val bwClass: BWClass) : BWInstruction(0) {
    override fun run(scope: Scope) {
        scope.registerClass(bwClass)
    }

}