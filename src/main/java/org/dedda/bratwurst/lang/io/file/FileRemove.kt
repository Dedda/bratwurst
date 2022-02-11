package org.dedda.bratwurst.lang.io.file

import org.dedda.bratwurst.lang.BWInstruction
import org.dedda.bratwurst.lang.BWString
import org.dedda.bratwurst.lang.scope.Scope
import java.io.File

/**
 * Created by dedda on 1/25/16.
 *
 * @author dedda
 */
class FileRemove(lineNumber: Int, private val variableName: String) : BWInstruction(lineNumber) {
    override fun run(scope: Scope) {
        val variable = scope.getVariable(variableName)
        if (variable.value !is BWString) {
            throw RuntimeException("variable not of type string!")
        }
        val fileName = (variable.value as BWString).stringValue
        val file = File(fileName)
        if (file.exists()) {
            file.delete()
        }
    }

}