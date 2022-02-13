package org.dedda.bratwurst.lang

import org.dedda.bratwurst.lang.scope.Scope

/**
 * Created by dedda on 10/16/15.
 *
 * @author dedda
 */
class FunctionCall : BWExpression {
    private val functionName: String
    private var variableName = ""
    private var value: BWObject = BWInteger(0)

    constructor(lineNumber: Int, functionName: String, functionArguments: Array<BWVariable>) : super(lineNumber) {
        this.functionName = functionName
        arguments = functionArguments
    }

    constructor(lineNumber: Int, variableName: String, functionName: String, functionArguments: Array<BWVariable>) : super(lineNumber) {
        this.variableName = variableName
        this.functionName = functionName
        arguments = functionArguments
    }

    override fun getValue(): BWObject {
        return value
    }

    override fun getIntValue(): Int {
        return value.intValue
    }

    override fun getValueType() = value.valueType

    override fun run(scope: Scope) {
        var function: BWFunction? = null
        if (variableName != "") {
            function = scope.getFunction(variableName, functionName)
        }
        if (function == null) {
            function = scope.getFunction(functionName)
        }
        if (function == null) {
            throw RuntimeException("$lineNumber: function $variableName.$functionName not set!")
        }
        for (argument in arguments) {
            argument.run(scope)
        }
        if (variableName != "") {
            scope.enterFunction(scope.getVariable(variableName).value, function, listOf(*arguments))
        } else {
            scope.enterFunction(function, listOf(*arguments))
        }
        function.arguments = arguments
        function.run(scope)
        value = function.value
        scope.leaveFunction()
    }
}