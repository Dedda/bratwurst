package org.dedda.bratwurst.parse;

import org.dedda.bratwurst.lang.Pop;

/**
 * Created by dedda on 12/8/15.
 *
 * @author dedda
 */
public class PopParser extends InstructionParser {

    public Pop parse(String line, int linenumber) {
        if (line.matches(Patterns.POP)) {
            String name = line.substring(1, line.length() - 1);
            return new Pop(linenumber, name);
        }
        return null;
    }

}
