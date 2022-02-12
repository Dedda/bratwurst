package org.dedda.bratwurst.parse

import org.dedda.bratwurst.lang.io.terminal.ReadLine

/**
 * Created by dedda on 1/28/16.
 *
 * @author dedda
 */
class ReadLineParser : ExpressionParser() {
    override fun parse(data: String, lineNumber: Int): ReadLine {
        return ReadLine(lineNumber)
    }
}