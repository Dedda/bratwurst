package org.dedda.bratwurst.parse

import org.dedda.bratwurst.lang.BWFunction
import org.dedda.bratwurst.lang.classes.BWClass
import java.util.*
import java.util.stream.IntStream

/**
 * Created by dedda on 9/25/15.
 *
 * @author dedda
 */
class BWClassParser {
    fun parse(lines: List<String>, begin: Int): BWClass {
        val end = getEnd(lines, begin)
        val trimmed = lines.map(String::trim)

        var className: String? = null
        val functions: MutableList<BWFunction> = LinkedList()
        val functionParser = BWFunctionParser()
        var i = begin
        while (i < end) {
            val line = trimmed[i]
            if (line.matches(Regex(Patterns.NAMING))) {
                className = line.split(" ").toTypedArray()[2]
                i++
                continue
            }
            if (line.matches(Regex(Patterns.FUNCTION_BEGIN))) {
                functions.add(functionParser.parse(trimmed, i))
                i = functionParser.getEndOfFunction(trimmed, i)
            }
            i++
        }
        if (className == null) {
            throw RuntimeException("class name not found!")
        }
        val functionsArray = functions.toTypedArray()
        return BWClass(className, functionsArray)
    }

    fun getEnd(lines: List<String>, begin: Int): Int {
        val pattern = Regex(Patterns.CLASS_END)
        return IntStream.range(begin, lines.size)
            .filter { line -> lines[line].trim().matches(pattern) }
            .findFirst()
            .orElseThrow {
                throw RuntimeException("no class end found!")
            }
    }
}