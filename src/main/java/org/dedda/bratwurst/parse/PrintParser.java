package org.dedda.bratwurst.parse;

import org.dedda.bratwurst.lang.instruction.Print;

/**
 * Created by dedda on 9/28/15.
 *
 * @author dedda
 */
public class PrintParser {

    public Print parse(String line) {
        String message = line.substring(1, line.length()-1);
        return new Print(message);
    }

}
