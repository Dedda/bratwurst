package org.dedda.bratwurst.lang

import org.dedda.bratwurst.lang.ValueType.STRING
import org.dedda.bratwurst.lang.scope.Scope

/**
 * Created by dedda on 1/25/16.
 *
 * @author dedda
 */
class StringConcatenation(lineNumber: Int, private val variableNames: Array<String>) : BWExpression(lineNumber) {
    private var value: String = ""
    override fun getValue(): BWObject {
        return BWString(value)
    }

    override fun getIntValue(): Int {
        var value = 0
        try {
            value = (getValue() as BWString).stringValue.toInt()
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return value
    }

    override fun getValueType() = STRING

    override fun run(scope: Scope) {
        val strings = arrayOfNulls<String>(variableNames.size)
        for (i in variableNames.indices) {
            val variable = scope.getVariable(variableNames[i])
            if (variable.value is BWString) {
                strings[i] = (variable.value as BWString).stringValue
            } else if (variable.value is BWInteger) {
                strings[i] = "" + variable.value.intValue
            } else {
                throw RuntimeException("variable not string or integer!")
            }
        }
        var data: String = ""
        for (string in strings) {
            data += string
        }
        value = data
    }

}