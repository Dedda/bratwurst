package org.dedda.bratwurst.parse;

import org.dedda.bratwurst.lang.BWInstruction;
import org.dedda.bratwurst.lang.PrintChar;
import org.dedda.bratwurst.lang.PrintInt;
import org.dedda.bratwurst.lang.PrintVariable;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.dedda.bratwurst.parse.Emoji.*;
import static org.dedda.bratwurst.parse.Patterns.PRINT;
import static org.dedda.bratwurst.parse.Patterns.PRINT_INT;
import static org.dedda.bratwurst.parse.Patterns.PRINT_VAR;
import static org.dedda.bratwurst.parse.Patterns.validVariableNameEmojis;

/**
 * Created by dedda on 9/28/15.
 *
 * @author dedda
 */
public class PrintParser extends InstructionParser {

    public BWInstruction parse(String line, int lineNumber) {
//        String message = line.substring(1, line.length()-1);
//        if (line.startsWith("|")) {
//            return new PrintInt(lineNumber, message);
//        }
//        if (message.length() == 1) {
//            return new PrintChar(lineNumber, message.charAt(0));
//        } else if (message.matches("^\\d+$")) {
//            return new PrintChar(lineNumber, (char) Integer.parseInt(message));
//        }
//        return new PrintVariable(lineNumber, message);
        if (line.matches(PRINT_INT)) {
            String message = line.substring(X_X.length(), line.length() - PIG.length());
            return new PrintInt(lineNumber, message);
        } else if (line.matches(PRINT_VAR)) {
            String message = line.substring(SNAKE.length(), line.length() - TURBAN.length());
            if (message.length() == 1) {
                return new PrintChar(lineNumber, message.charAt(0));
            } else if (message.matches("^\\d+$")) {
                return new PrintChar(lineNumber, (char) Integer.parseInt(message));
            }
            if (!new StringValidator().isValid(message, validVariableNameEmojis())) {
                throw new RuntimeException("\"" + message + "\" is not a valid variable name!");
            }
            return new PrintVariable(lineNumber, message);
        }
        return null;
    }

}
