package org.dedda.bratwurst.parse;

import org.dedda.bratwurst.lang.Exit;

import static org.dedda.bratwurst.parse.Patterns.END;

/**
 * Created by dedda on 10/16/15.
 *
 * @author dedda
 */
public class ExitParser {

    public Exit parse(String line, int lineNumber) {
        return line.matches(END) ? new Exit(lineNumber) : null;
    }

}
