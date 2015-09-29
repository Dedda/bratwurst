package org.dedda.bratwurst.parse;

import org.dedda.bratwurst.lang.instruction.Print;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.dedda.bratwurst.parse.Patterns.PRINT;

/**
 * Created by dedda on 9/28/15.
 *
 * @author dedda
 */
public class PrintParser {

    public Print parse(String line) {
        Pattern pattern = Pattern.compile(PRINT);
        Matcher matcher = pattern.matcher(line);
        String message = "";
        if (matcher.find()) {
            message = matcher.group(1);
        }
        return new Print(message);
    }

}
