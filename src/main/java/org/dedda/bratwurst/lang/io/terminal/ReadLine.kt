package org.dedda.bratwurst.lang.io.terminal

import org.dedda.bratwurst.lang.BWExpression
import org.dedda.bratwurst.lang.BWObject
import org.dedda.bratwurst.lang.BWString
import org.dedda.bratwurst.lang.scope.Scope
import java.util.*

/**
 * Created by dedda on 1/28/16.
 *
 * @author dedda
 */
class ReadLine(lineNumber: Int) : BWExpression(lineNumber) {
    private var read: String? = null
    override fun getValue(): BWObject {
        return BWString(read)
    }

    override fun getIntValue(): Int {
        return value.intValue
    }

    override fun getValueType(): String {
        return "string"
    }

    override fun run(scope: Scope) {
        val scanner = Scanner(System.`in`)
        read = scanner.nextLine()
    }
}