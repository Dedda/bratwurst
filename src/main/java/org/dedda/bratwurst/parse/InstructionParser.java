package org.dedda.bratwurst.parse;

import org.dedda.bratwurst.lang.BWInstruction;
import org.dedda.bratwurst.lang.Pop;

import static org.dedda.bratwurst.parse.Patterns.END;
import static org.dedda.bratwurst.parse.Patterns.FUNCTION_CALL;
import static org.dedda.bratwurst.parse.Patterns.POP;
import static org.dedda.bratwurst.parse.Patterns.PRINT;
import static org.dedda.bratwurst.parse.Patterns.PUSH;
import static org.dedda.bratwurst.parse.Patterns.RETURN;
import static org.dedda.bratwurst.parse.Patterns.VARIABLE_DECLARATION;

/**
 * Created by dedda on 10/17/15.
 *
 * @author dedda
 */
public class InstructionParser {

    public BWInstruction parse(String line, int lineNumber) {
        line = line.replace((char) 10, ' ');
        line = line.replace((char) 13, ' ');
        line.trim();
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
        }
        return null;
    }

}
