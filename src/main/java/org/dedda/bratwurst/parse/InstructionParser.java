package org.dedda.bratwurst.parse;

import org.dedda.bratwurst.lang.BWInstruction;

import static org.dedda.bratwurst.parse.Patterns.*;

/**
 * Created by dedda on 10/17/15.
 *
 * @author dedda
 */
public class InstructionParser {

    public BWInstruction parse(String line, int lineNumber) {
        line = line.trim();
        if (line.matches("^" + FUNCTION_CALL)) {
            return new FunctionCallParser().parse(line, lineNumber);
        } else if (line.matches(VARIABLE_DECLARATION)) {
            return new VariableDeclarationParser().parseDeclaration(line, lineNumber);
        } else if (line.matches(PRINT)) {
            return new PrintParser().parse(line, lineNumber);
        } else if (line.matches(END)) {
            return new ExitParser().parse(line, lineNumber);
        } else if (line.matches(RETURN)) {
            return new ReturnParser().parse(line, lineNumber);
        } else if (line.matches(POP)) {
            return new PopParser().parse(line, lineNumber);
        } else if (line.matches(PUSH)) {
            return new PushParser().parse(line, lineNumber);
        } else if (line.matches(ASSERT_EQUALS)) {
            return new AssertEqualsParser().parse(line, lineNumber);
        } else if (line.matches(ASSERT_NOT_EQUALS)) {
            return new AssertNotEqualsParser().parse(line, lineNumber);
        } else if (line.matches(ASSERT_TRUE)) {
            return new AssertTrueParser().parse(line, lineNumber);
        } else if (line.matches(ASSERT_FALSE)) {
            return new AssertFalseParser().parse(line, lineNumber);
        } else if (line.matches(FILE_CREATE)) {
            return new FileCreateParser().parse(line, lineNumber);
        } else if (line.matches(FILE_REMOVE)) {
            return new FileRemoveParser().parse(line, lineNumber);
        } else if (line.matches(FILE_IMPORT)) {
            return new FileImportParser().parse(line, lineNumber);
        } else if (line.matches(FILE_EXPORT)) {
            return new FileExportParser().parse(line, lineNumber);
        }
        return null;
    }

}
