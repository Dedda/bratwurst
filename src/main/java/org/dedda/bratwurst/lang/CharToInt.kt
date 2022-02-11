package org.dedda.bratwurst.lang

import org.dedda.bratwurst.lang.ValueType.INTEGER
import org.dedda.bratwurst.lang.scope.Scope

/**
 * Created by dedda on 1/28/16.
 *
 * @author dedda
 */
class CharToInt(lineNumber: Int, private val varname: String) : BWExpression(lineNumber) {
    private var value = 0
    override fun getValue(): BWObject {
        return BWInteger(value)
    }

    override fun getIntValue(): Int {
        return value
    }

    override fun getValueType() = INTEGER

    override fun run(scope: Scope) {
        val variable = scope.getVariable(varname)
        if (variable.value !is BWString) {
            throw RuntimeException("Variable not of type string")
        }
        val value = variable.value as BWString
        if (value.stringValue!!.length != 1) {
            throw RuntimeException("String not length of 1")
        }
        this.value = value.stringValue[0].toInt()
    }

}