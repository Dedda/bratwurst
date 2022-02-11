package org.dedda.bratwurst.lang.io.file

import org.dedda.bratwurst.lang.BWExpression
import org.dedda.bratwurst.lang.BWInteger
import org.dedda.bratwurst.lang.BWObject
import org.dedda.bratwurst.lang.BWString
import org.dedda.bratwurst.lang.ValueType.INTEGER
import org.dedda.bratwurst.lang.scope.Scope
import java.io.File

/**
 * Created by dedda on 1/25/16.
 *
 * @author dedda
 */
class FileExists(lineNumber: Int, private val variableName: String) : BWExpression(lineNumber) {
    private var exists = false
    override fun getValue(): BWObject {
        return BWInteger(intValue)
    }

    override fun getIntValue(): Int {
        return if (exists) 1 else 0
    }

    override fun getValueType() = INTEGER

    override fun run(scope: Scope) {
        val variable = scope.getVariable(variableName)
        if (variable.value !is BWString) {
            throw RuntimeException("variable not of type string!")
        }
        val fileName = (variable.value as BWString).stringValue
        val file = File(fileName)
        exists = file.exists()
    }

}