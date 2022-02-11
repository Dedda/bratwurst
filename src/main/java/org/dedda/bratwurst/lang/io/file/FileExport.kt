package org.dedda.bratwurst.lang.io.file

import org.dedda.bratwurst.lang.BWInstruction
import org.dedda.bratwurst.lang.BWString
import org.dedda.bratwurst.lang.scope.Scope
import java.io.BufferedWriter
import java.io.File
import java.io.FileWriter
import java.io.IOException

/**
 * Created by dedda on 1/25/16.
 *
 * @author dedda
 */
class FileExport(lineNumber: Int, private val sourceVariableName: String, private val destinationVariableName: String) : BWInstruction(lineNumber) {
    override fun run(scope: Scope) {
        val sourceVariable = scope.getVariable(sourceVariableName)
        val destinationVariable = scope.getVariable(destinationVariableName)
        if (sourceVariable.value !is BWString) {
            throw RuntimeException("variable not of type string!")
        }
        if (destinationVariable.value !is BWString) {
            throw RuntimeException("variable not of type string!")
        }
        val fileName = (destinationVariable.value as BWString).stringValue
        val file = File(fileName)
        if (!file.exists()) {
            throw RuntimeException("file $fileName does not exists!")
        }
        val data = (sourceVariable.value as BWString).stringValue
        try {
            val writer = BufferedWriter(FileWriter(file))
            writer.write(data)
            writer.flush()
            writer.close()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

}