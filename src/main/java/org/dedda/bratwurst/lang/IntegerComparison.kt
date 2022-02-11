package org.dedda.bratwurst.lang

import org.dedda.bratwurst.lang.scope.Scope
import org.dedda.bratwurst.tool.IntegerComparator

/**
 * Created by dedda on 1/28/16.
 *
 * @author dedda
 */
class IntegerComparison(lineNumber: Int, private val varName1: String, private val varName2: String) : BWExpression(lineNumber) {
    private var comparison = 0
    override fun getValue(): BWObject {
        return BWInteger(comparison)
    }

    override fun getIntValue(): Int {
        return comparison
    }

    override fun getValueType(): String {
        return "integer"
    }

    override fun run(scope: Scope) {
        val var1 = scope.getVariable(varName1)
        val var2 = scope.getVariable(varName2)
        if (!(var1.value is BWInteger && var2.value is BWInteger)) {
            comparison = 0
            return
        }
        val comparator = IntegerComparator()
        comparison = comparator.compareLge(var1.value as BWInteger, var2.value as BWInteger)
    }

}