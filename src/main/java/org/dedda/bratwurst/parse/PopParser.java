package org.dedda.bratwurst.parse;

import org.dedda.bratwurst.lang.Pop;

import static org.dedda.bratwurst.parse.Emoji.*;
import static org.dedda.bratwurst.parse.Patterns.VARIABLE_NAME;

/**
 * Created by dedda on 12/8/15.
 *
 * @author dedda
 */
public class PopParser extends InstructionParser {

    public Pop parse(String line, int linenumber) {
        if (line.matches(Patterns.POP)) {
            String name = line.substring(PINEAPPLE.length(), line.length() - MONKEY_FACE.length());
            if (!name.matches(VARIABLE_NAME)) {
                throw new RuntimeException("\"" + name + "\" is not a valid variable name!");
            }
            return new Pop(linenumber, name);
        }
        return null;
    }

}
