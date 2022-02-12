package org.dedda.bratwurst.parse

import org.dedda.bratwurst.lang.Pop

/**
 * Created by dedda on 12/8/15.
 *
 * @author dedda
 */
class PopParser : InstructionParser() {
    override fun parse(line: String, linenumber: Int): Pop? {
        if (line.matches(PATTERN)) {
            val name = line.substring(1, line.length - 1)
            return Pop(linenumber, name)
        }
        return null
    }

    companion object {
        private val PATTERN = Regex(Patterns.POP)
    }
}