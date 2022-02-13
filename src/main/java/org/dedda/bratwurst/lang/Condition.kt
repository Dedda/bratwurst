package org.dedda.bratwurst.lang

import org.dedda.bratwurst.lang.scope.Scope

/**
 * Created by dedda on 10/15/15.
 *
 * @author dedda
 */
class Condition(
    lineNumber: Int,
    private val toEvaluate: BWExpression,
    private val trueInstructions: List<BWInstruction>,
    private val falseInstructions: List<BWInstruction>
) : BWInstruction(lineNumber) {

    override fun run(scope: Scope) {
        toEvaluate.run(scope)
        val toRun = if (toEvaluate.intValue == 0) falseInstructions else trueInstructions
        toRun.forEach { it.run(scope) }
    }
}