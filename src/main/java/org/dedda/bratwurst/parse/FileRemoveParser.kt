package org.dedda.bratwurst.parse

import org.dedda.bratwurst.lang.io.file.FileRemove

/**
 * Created by dedda on 1/25/16.
 *
 * @author dedda
 */
class FileRemoveParser : InstructionParser() {
    override fun parse(line: String, lineNumber: Int): FileRemove {
        val variableName = line.substring(1, line.length - 1)
        return FileRemove(lineNumber, variableName)
    }
}