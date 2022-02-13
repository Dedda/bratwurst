package org.dedda.bratwurst.lang

import org.dedda.bratwurst.lang.scope.Scope

/**
 * Created by dedda on 10/15/15.
 *
 * @author dedda
 */
class Loop(lineNumber: Int, private val toEvaluate: BWExpression, private val instructions: List<BWInstruction>) : BWInstruction(lineNumber) {
    override fun run(scope: Scope) {
        var run: Boolean
        toEvaluate.run(scope)
        run = toEvaluate.intValue != 0
        while (run) {
            runInstructions(scope)
            toEvaluate.run(scope)
            run = toEvaluate.intValue != 0
        }
    }

    private fun runInstructions(scope: Scope) {
        for (instruction in instructions) {
            instruction.run(scope)
        }
    }

}