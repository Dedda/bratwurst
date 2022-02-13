package org.dedda.bratwurst.parse

import org.dedda.bratwurst.lang.Condition
import org.dedda.bratwurst.parse.Patterns.CONDITION_END
import org.dedda.bratwurst.parse.Patterns.CONDITION_SEPARATOR
import java.util.stream.IntStream

/**
 * Created by dedda on 10/19/15.
 *
 * @author dedda
 */
class ConditionParser {
    fun parse(lines: List<String>, begin: Int): Condition {
        val end = findEnd(lines, begin)
        val separator = findSeparator(lines, begin)
        val conditionLine = lines[begin]
        val trueInstructions = (begin + 1 until separator)
            .mapNotNull { InstructionParser().parse(lines[it], it) }
            .toList()
        val falseInstructions = (separator + 1 until end)
            .mapNotNull { InstructionParser().parse(lines[it], it) }
            .toList()
        val condition = ExpressionParser().parse(conditionLine.substring(2, conditionLine.length - 3), begin)
        return Condition(begin, condition, trueInstructions, falseInstructions)
    }

    fun findEnd(lines: List<String>, begin: Int): Int {
        val pattern = Regex(CONDITION_END)
        return IntStream.range(begin, lines.size)
            .filter { line: Int -> lines[line].matches(pattern) }
            .findFirst()
            .orElseThrow { RuntimeException("No condition end found!") }
    }

    private fun findSeparator(lines: List<String>, begin: Int): Int {
        val pattern = Regex(CONDITION_SEPARATOR)
        return IntStream.range(begin, lines.size)
            .filter { line: Int -> lines[line].matches(pattern) }
            .findFirst()
            .orElseThrow { RuntimeException("No condition separator found!") }
    }
}