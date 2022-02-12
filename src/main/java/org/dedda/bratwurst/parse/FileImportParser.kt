package org.dedda.bratwurst.parse

import org.dedda.bratwurst.lang.io.file.FileImport

/**
 * Created by dedda on 1/25/16.
 *
 * @author dedda
 */
class FileImportParser : InstructionParser() {
    override fun parse(line: String, lineNumber: Int): FileImport {
        val variableName = line.substring(2, line.length - 2)
        return FileImport(lineNumber, variableName)
    }
}