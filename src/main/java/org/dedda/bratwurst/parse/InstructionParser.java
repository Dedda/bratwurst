package org.dedda.bratwurst.parse;

import org.dedda.bratwurst.lang.BWInstruction;

import static org.dedda.bratwurst.parse.Patterns.END;
import static org.dedda.bratwurst.parse.Patterns.FUNCTION_CALL;
import static org.dedda.bratwurst.parse.Patterns.PRINT;
import static org.dedda.bratwurst.parse.Patterns.RETURN;
import static org.dedda.bratwurst.parse.Patterns.VARIABLE_DECLARATION;

/**
 * Created by dedda on 10/17/15.
 *
 * @author dedda
 */
public class InstructionParser {

    public BWInstruction parse(String line, int lineNumber) {
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
        }
        return null;
    }

}
