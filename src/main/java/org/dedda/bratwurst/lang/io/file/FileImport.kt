package org.dedda.bratwurst.lang.io.file

import org.dedda.bratwurst.lang.BWInstruction
import org.dedda.bratwurst.lang.BWString
import org.dedda.bratwurst.lang.scope.Scope
import java.io.BufferedReader
import java.io.File
import java.io.FileReader
import java.io.IOException

/**
 * Created by dedda on 1/25/16.
 *
 * @author dedda
 */
class FileImport(lineNumber: Int, private val variableName: String) : BWInstruction(lineNumber) {
    override fun run(scope: Scope) {
        val variable = scope.getVariable(variableName)
        if (variable.value !is BWString) {
            throw RuntimeException("variable not of type string!")
        }
        val fileName = (variable.value as BWString).stringValue
        val file = File(fileName)
        if (!file.exists()) {
            throw RuntimeException("file $fileName does not exists!")
        }
        try {
            val reader = BufferedReader(FileReader(file))
            var data: String? = ""
            var buffer: String?
            while (reader.readLine().also { buffer = it } != null) {
                data += buffer
            }
            reader.close()
            variable.value = BWString(data)
            scope.setVariable(variable)
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

}