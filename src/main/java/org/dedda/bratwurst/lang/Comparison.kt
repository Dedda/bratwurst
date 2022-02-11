package org.dedda.bratwurst.lang

import org.dedda.bratwurst.lang.ValueType.INTEGER
import org.dedda.bratwurst.lang.scope.Scope
import org.dedda.bratwurst.tool.IntegerComparator
import org.dedda.bratwurst.tool.ObjectComparator
import org.dedda.bratwurst.tool.StringComparator

/**
 * Created by dedda on 1/28/16.
 *
 * @author dedda
 */
class Comparison(lineNumber: Int, private val varName1: String, private val varName2: String) : BWExpression(lineNumber) {
    private var equals = false
    override fun getValue(): BWObject {
        return BWInteger(intValue)
    }

    override fun getIntValue(): Int {
        return if (equals) 1 else 0
    }

    override fun getValueType() = INTEGER

    override fun run(scope: Scope) {
        val var1 = scope.getVariable(varName1)
        val var2 = scope.getVariable(varName2)
        if (var1.value.javaClass != var2.value.javaClass) {
            equals = false
            return
        }
        equals = when (var1.value) {
            is BWInteger -> {
                IntegerComparator().compare(var1.value as BWInteger, var2.value as BWInteger)
            }
            is BWString -> {
                StringComparator().compare(var1.value as BWString, var2.value as BWString)
            }
            else -> {
                ObjectComparator().compare(var1.value, var2.value)
            }
        }
    }

}