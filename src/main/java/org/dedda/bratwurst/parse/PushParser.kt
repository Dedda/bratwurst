package org.dedda.bratwurst.parse

import org.dedda.bratwurst.lang.Push

/**
 * Created by dedda on 12/8/15.
 *
 * @author dedda
 */
class PushParser : InstructionParser() {
    override fun parse(line: String, linenumber: Int): Push? {
        if (line.matches(PATTERN)) {
            val expression = line.substring(1, line.length - 1)
            val argument = ExpressionParser().parse(expression, linenumber)
            return Push(linenumber, argument)
        }
        return null
    }

    companion object {
        private val PATTERN = Regex(Patterns.PUSH)
    }
}