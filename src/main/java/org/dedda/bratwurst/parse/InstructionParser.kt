package org.dedda.bratwurst.parse;

import org.dedda.bratwurst.lang.BWInstruction;

import static org.dedda.bratwurst.parse.Patterns.*;

/**
 * Created by dedda on 10/17/15.
 *
 * @author dedda
 */
public class InstructionParser {

    public BWInstruction parse(final String line, final int lineNumber) {
        final String trimmed = line.trim();
        if (trimmed.matches("^" + FUNCTION_CALL)) {
            return new FunctionCallParser().parse(trimmed, lineNumber);
        } else if (trimmed.matches(VARIABLE_DECLARATION)) {
            return new VariableDeclarationParser().parseDeclaration(trimmed, lineNumber);
        } else if (trimmed.matches(PRINT)) {
            return new PrintParser().parse(trimmed, lineNumber);
        } else if (trimmed.matches(END)) {
            return new ExitParser().parse(trimmed, lineNumber);
        } else if (trimmed.matches(RETURN)) {
            return new ReturnParser().parse(trimmed, lineNumber);
        } else if (trimmed.matches(POP)) {
            return new PopParser().parse(trimmed, lineNumber);
        } else if (trimmed.matches(PUSH)) {
            return new PushParser().parse(trimmed, lineNumber);
        } else if (trimmed.matches(ASSERT_EQUALS)) {
            return new AssertEqualsParser().parse(trimmed, lineNumber);
        } else if (trimmed.matches(ASSERT_NOT_EQUALS)) {
            return new AssertNotEqualsParser().parse(trimmed, lineNumber);
        } else if (trimmed.matches(ASSERT_TRUE)) {
            return new AssertTrueParser().parse(trimmed, lineNumber);
        } else if (trimmed.matches(ASSERT_FALSE)) {
            return new AssertFalseParser().parse(trimmed, lineNumber);
        } else if (trimmed.matches(FILE_CREATE)) {
            return new FileCreateParser().parse(trimmed, lineNumber);
        } else if (trimmed.matches(FILE_REMOVE)) {
            return new FileRemoveParser().parse(trimmed, lineNumber);
        } else if (trimmed.matches(FILE_IMPORT)) {
            return new FileImportParser().parse(trimmed, lineNumber);
        } else if (trimmed.matches(FILE_EXPORT)) {
            return new FileExportParser().parse(trimmed, lineNumber);
        }
        return null;
    }
}
