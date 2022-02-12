package org.dedda.bratwurst.parse

import org.dedda.bratwurst.lang.BWFunction
import org.dedda.bratwurst.lang.classes.BWClass
import java.util.*

/**
 * Created by dedda on 9/25/15.
 *
 * @author dedda
 */
class BWClassParser {
    fun parse(lines: Array<String>, begin: Int): BWClass {
        val end = getEnd(lines, begin)
        for (i in lines.indices) {
            lines[i] = lines[i].trim()
        }
        var className: String? = null
        val functions: MutableList<BWFunction> = LinkedList()
        val functionParser = BWFunctionParser()
        var i = begin
        while (i < end) {
            val line = lines[i]
            if (line.matches(Regex(Patterns.NAMING))) {
                className = line.split(" ").toTypedArray()[2]
                i++
                continue
            }
            if (line.matches(Regex(Patterns.FUNCTION_BEGIN))) {
                functions.add(functionParser.parse(lines, i))
                i = functionParser.getEndOfFunction(lines, i)
            }
            i++
        }
        if (className == null) {
            throw RuntimeException("class name not found!")
        }
        val functionsArray = functions.toTypedArray()
        return BWClass(className, functionsArray)
    }

    fun getEnd(lines: Array<String>, begin: Int): Int {
        for (i in begin until lines.size) {
            if (lines[i].trim().matches(Regex(Patterns.CLASS_END))) {
                return i
            }
        }
        throw RuntimeException("no class end found!")
    }
}