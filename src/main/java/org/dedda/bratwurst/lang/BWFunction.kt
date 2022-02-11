package org.dedda.bratwurst.lang

import org.dedda.bratwurst.lang.scope.Scope

/**
 * Created by dedda on 10/9/15.
 *
 * @author dedda
 */
class BWFunction(val name: String, val instructions: Array<BWInstruction>) : BWExpression(0) {
    private val variables: MutableList<BWVariable> = ArrayList()
    private var value: BWObject = BWInteger(0)
    override fun getValue(): BWObject {
        return value
    }

    override fun getIntValue(): Int {
        return value.intValue
    }

    override fun getValueType(): String {
        return value.valueType
    }

    override fun run(scope: Scope) {
        variables.addAll(listOf(*arguments))
        for (argument in arguments) {
            argument.run(scope)
        }
        for (instruction in instructions) {
            instruction.run(scope)
            if (instruction is Return) {
                value = instruction.value
                break
            }
        }
    }

    fun getVariables(): List<BWVariable> {
        return variables
    }

}