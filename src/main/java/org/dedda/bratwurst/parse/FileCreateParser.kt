package org.dedda.bratwurst.parse

import org.dedda.bratwurst.lang.io.file.FileCreate

/**
 * Created by dedda on 1/25/16.
 *
 * @author dedda
 */
class FileCreateParser : InstructionParser() {
    override fun parse(line: String, lineNumber: Int): FileCreate {
        val variableName = line.substring(1, line.length - 1)
        return FileCreate(lineNumber, variableName)
    }
}