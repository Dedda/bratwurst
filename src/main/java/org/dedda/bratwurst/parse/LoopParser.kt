package org.dedda.bratwurst.parse

import org.dedda.bratwurst.lang.Loop
import org.dedda.bratwurst.parse.Patterns.LOOP_END
import java.util.stream.IntStream
import kotlin.streams.toList

/**
 * Created by dedda on 10/19/15.
 *
 * @author dedda
 */
class LoopParser {
    fun parse(lines: List<String>, begin: Int): Loop {
        val end = getEnd(lines, begin)
        val head = ExpressionParser().parse(lines[begin].substring(2, lines[begin].length - 1), begin)
        val instructionParser = InstructionParser()
        val instructions = IntStream.range(begin + 1, end)
            .mapToObj { line: Int -> instructionParser.parse(lines[line], line) }
            .toList()
            .filterNotNull()
        return Loop(begin, head, instructions)
    }

    fun getEnd(lines: List<String>, begin: Int): Int {
        val pattern = Regex(LOOP_END)
        return IntStream.range(begin, lines.size)
            .filter { line: Int -> lines[line].matches(pattern) }
            .findFirst()
            .orElseThrow { RuntimeException("No loop end found!") }
    }
}