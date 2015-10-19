package org.dedda.bratwurst.parse;

import org.dedda.bratwurst.lang.BWInstruction;
import org.dedda.bratwurst.lang.PrintChar;
import org.dedda.bratwurst.lang.PrintVariable;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.dedda.bratwurst.parse.Patterns.PRINT;

/**
 * Created by dedda on 9/28/15.
 *
 * @author dedda
 */
public class PrintParser {

    public BWInstruction parse(String line, int lineNumber) {
        Pattern pattern = Pattern.compile(PRINT);
        Matcher matcher = pattern.matcher(line);
        String message = "";
        if (matcher.find()) {
            message = matcher.group(1);
        }
        if (message.length() == 1) {
            return new PrintChar(lineNumber, message.charAt(0));
        } else if (message.matches("^\\d+$")) {
            return new PrintChar(lineNumber, (char) Integer.parseInt(message));
        }
        return new PrintVariable(lineNumber, message);
    }

}
