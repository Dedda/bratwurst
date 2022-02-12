package org.dedda.bratwurst.parse

import org.dedda.bratwurst.lang.Exit

/**
 * Created by dedda on 10/16/15.
 *
 * @author dedda
 */
class ExitParser : InstructionParser() {
    override fun parse(line: String, lineNumber: Int): Exit? {
        return if (line.matches(Regex(Patterns.END))) Exit(lineNumber) else null
    }
}