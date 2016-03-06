package org.dedda.bratwurst.parse;

import org.dedda.bratwurst.lang.BWInstruction;
import org.dedda.bratwurst.lang.PrintChar;
import org.dedda.bratwurst.lang.PrintInt;
import org.dedda.bratwurst.lang.PrintVariable;

/**
 * Created by dedda on 9/28/15.
 *
 * @author dedda
 */
public class PrintParser extends InstructionParser {

    public BWInstruction parse(String line, int lineNumber) {
        String message = line.substring(1, line.length()-1);
        if (line.startsWith("|")) {
            return new PrintInt(lineNumber, message);
        }
        if (message.length() == 1) {
            return new PrintChar(lineNumber, message.charAt(0));
        } else if (message.matches("^\\d+$")) {
            return new PrintChar(lineNumber, (char) Integer.parseInt(message));
        }
        return new PrintVariable(lineNumber, message);
    }

}
