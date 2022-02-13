package org.dedda.bratwurst.parse

import org.dedda.bratwurst.lang.BWInstruction
import org.dedda.bratwurst.parse.Patterns.ASSERT_EQUALS
import org.dedda.bratwurst.parse.Patterns.ASSERT_FALSE
import org.dedda.bratwurst.parse.Patterns.ASSERT_NOT_EQUALS
import org.dedda.bratwurst.parse.Patterns.ASSERT_TRUE
import org.dedda.bratwurst.parse.Patterns.END
import org.dedda.bratwurst.parse.Patterns.FILE_CREATE
import org.dedda.bratwurst.parse.Patterns.FILE_EXPORT
import org.dedda.bratwurst.parse.Patterns.FILE_IMPORT
import org.dedda.bratwurst.parse.Patterns.FILE_REMOVE
import org.dedda.bratwurst.parse.Patterns.FUNCTION_CALL
import org.dedda.bratwurst.parse.Patterns.POP
import org.dedda.bratwurst.parse.Patterns.PRINT
import org.dedda.bratwurst.parse.Patterns.PUSH
import org.dedda.bratwurst.parse.Patterns.RETURN
import org.dedda.bratwurst.parse.Patterns.VARIABLE_DECLARATION

/**
 * Created by dedda on 10/17/15.
 *
 * @author dedda
 */
open class InstructionParser {
    open fun parse(line: String, lineNumber: Int): BWInstruction? {
        val trimmed = line.trim { it <= ' ' }
        if (trimmed.matches(Regex("^$FUNCTION_CALL"))) {
            return FunctionCallParser().parse(trimmed, lineNumber)
        } else if (trimmed.matches(Regex(VARIABLE_DECLARATION))) {
            return VariableDeclarationParser().parseDeclaration(trimmed, lineNumber)
        } else if (trimmed.matches(Regex(PRINT))) {
            return PrintParser().parse(trimmed, lineNumber)
        } else if (trimmed.matches(Regex(END))) {
            return ExitParser().parse(trimmed, lineNumber)
        } else if (trimmed.matches(Regex(RETURN))) {
            return ReturnParser().parse(trimmed, lineNumber)
        } else if (trimmed.matches(Regex(POP))) {
            return PopParser().parse(trimmed, lineNumber)
        } else if (trimmed.matches(Regex(PUSH))) {
            return PushParser().parse(trimmed, lineNumber)
        } else if (trimmed.matches(Regex(ASSERT_EQUALS))) {
            return AssertEqualsParser().parse(trimmed, lineNumber)
        } else if (trimmed.matches(Regex(ASSERT_NOT_EQUALS))) {
            return AssertNotEqualsParser().parse(trimmed, lineNumber)
        } else if (trimmed.matches(Regex(ASSERT_TRUE))) {
            return AssertTrueParser().parse(trimmed, lineNumber)
        } else if (trimmed.matches(Regex(ASSERT_FALSE))) {
            return AssertFalseParser().parse(trimmed, lineNumber)
        } else if (trimmed.matches(Regex(FILE_CREATE))) {
            return FileCreateParser().parse(trimmed, lineNumber)
        } else if (trimmed.matches(Regex(FILE_REMOVE))) {
            return FileRemoveParser().parse(trimmed, lineNumber)
        } else if (trimmed.matches(Regex(FILE_IMPORT))) {
            return FileImportParser().parse(trimmed, lineNumber)
        } else if (trimmed.matches(Regex(FILE_EXPORT))) {
            return FileExportParser().parse(trimmed, lineNumber)
        }
        return null
    }
}