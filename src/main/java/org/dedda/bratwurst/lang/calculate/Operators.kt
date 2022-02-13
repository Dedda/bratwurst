package org.dedda.bratwurst.lang.calculate

typealias CalcOperation = (Int, Int) -> Int

fun operationForChar(c: Char): CalcOperation = when (c) {
    '+' -> { left, right -> left + right}
    '-' -> { left, right -> left - right}
    '*' -> { left, right -> left * right}
    '/' -> { left, right -> left / right}
    else -> throw IllegalArgumentException("Unknown operator `$c`")
}
