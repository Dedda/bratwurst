package org.dedda.bratwurst.parse

import org.dedda.bratwurst.lang.BWInstruction
import org.dedda.bratwurst.lang.PrintChar
import org.dedda.bratwurst.lang.PrintInt
import org.dedda.bratwurst.lang.PrintVariable

/**
 * Created by dedda on 9/28/15.
 *
 * @author dedda
 */
class PrintParser : InstructionParser() {
    override fun parse(line: String, lineNumber: Int): BWInstruction {
        val message = line.substring(1, line.length - 1)
        if (line.startsWith("|")) {
            return PrintInt(lineNumber, message)
        }
        if (message.length == 1) {
            return PrintChar(lineNumber, message[0])
        } else if (message.matches(Regex("^\\d+$"))) {
            return PrintChar(lineNumber, message.toInt().toChar())
        }
        return PrintVariable(lineNumber, message)
    }
}