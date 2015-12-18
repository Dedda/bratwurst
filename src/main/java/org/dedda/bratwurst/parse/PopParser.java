package org.dedda.bratwurst.parse;

import org.dedda.bratwurst.lang.Pop;

import static org.dedda.bratwurst.parse.Emoji.*;

/**
 * Created by dedda on 12/8/15.
 *
 * @author dedda
 */
public class PopParser extends InstructionParser {

    public Pop parse(String line, int linenumber) {
        if (line.matches(Patterns.POP)) {
            String name = line.substring(PINEAPPLE.length(), line.length() - MONKEY_FACE.length());
            return new Pop(linenumber, name);
        }
        return null;
    }

}
