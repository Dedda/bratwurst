package org.dedda.bratwurst.lang

import org.dedda.bratwurst.lang.ValueType.STRING
import org.dedda.bratwurst.lang.scope.Scope

/**
 * Created by dedda on 1/25/16.
 *
 * @author dedda
 */
class StringGetChar(lineNumber: Int, private val location: String, private val varName: String) : BWExpression(lineNumber) {
    private var value = ""
    override fun getValue(): BWObject {
        return BWString(value)
    }

    override fun getIntValue(): Int {
        return if (value.matches(NUMERIC_REGEX)) {
            value.toInt()
        } else 0
    }

    override fun getValueType() = STRING

    override fun run(scope: Scope) {
        val location: Int
        location = if (this.location.matches(NUMERIC_REGEX)) {
            this.location.toInt()
        } else {
            val locVar = scope.getVariable(this.location)
            if (locVar.value is BWString) {
                if ((locVar.value as BWString).stringValue!!.matches(NUMERIC_REGEX)) {
                    locVar.intValue
                } else {
                    throw RuntimeException("location is not a number!")
                }
            } else if (locVar.value is BWInteger) {
                locVar.intValue
            } else {
                throw RuntimeException("location not of type string or integer")
            }
        }
        val variable = scope.getVariable(varName)
        val text: String?
        text = if (variable.value is BWString) {
            (variable.value as BWString).stringValue
        } else if (variable.value is BWInteger) {
            "" + variable.intValue
        } else {
            throw RuntimeException("variable not of type string or integer")
        }
        value = "" + text!![location]
    }

    companion object {
        val NUMERIC_REGEX = Regex("\\d+")
    }

}