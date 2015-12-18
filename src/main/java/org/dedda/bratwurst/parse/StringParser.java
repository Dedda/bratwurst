package org.dedda.bratwurst.parse;

import org.dedda.bratwurst.lang.BWString;

/**
 * Created by dedda on 12/10/15.
 *
 * @author dedda
 */
public class StringParser extends ExpressionParser {

    @Override
    public BWString parse(String data, int lineNumber) {
        if (data.matches(Patterns.BW_STRING)) {
            String message = data.substring(Emoji.POODLE.length(), data.length() - Emoji.POOP.length());
            return new BWString(message);
        }
        return null;
    }

}
