package org.dedda.bratwurst.lang

import org.dedda.bratwurst.lang.scope.Scope

/**
 * Created by dedda on 1/28/16.
 *
 * @author dedda
 */
class IntToChar(lineNumber: Int, private val varname: String) : BWExpression(lineNumber) {
    private var value = 0.toChar()
    override fun getValue(): BWObject {
        return BWString(value.toString() + "")
    }

    override fun getIntValue(): Int {
        return value.toInt()
    }

    override fun getValueType(): String {
        return "string"
    }

    override fun run(scope: Scope) {
        val variable = scope.getVariable(varname)
        if (variable.value !is BWInteger) {
            throw RuntimeException("Variable not of type integer")
        }
        value = variable.value.intValue.toChar()
    }

}