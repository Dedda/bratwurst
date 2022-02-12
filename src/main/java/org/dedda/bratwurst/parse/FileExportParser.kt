package org.dedda.bratwurst.parse

import org.dedda.bratwurst.lang.io.file.FileExport

/**
 * Created by dedda on 1/25/16.
 *
 * @author dedda
 */
class FileExportParser : InstructionParser() {
    override fun parse(line: String, lineNumber: Int): FileExport {
        val split = line.split(" ".toRegex()).toTypedArray()
        val dataVarName = split[0].substring(2)
        val destVarName = split[2].substring(0, split[2].length - 2)
        return FileExport(lineNumber, dataVarName, destVarName)
    }
}