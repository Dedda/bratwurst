package org.dedda.bratwurst.parse;

import org.dedda.bratwurst.lang.ObjectCreation;

/**
 * Created by dedda on 10/17/15.
 *
 * @author dedda
 */
public class ObjectCreationParser {

    public ObjectCreation parse(String line, int lineNumber) {
        line = line.trim();
        return new ObjectCreation(lineNumber, line.substring(1, line.length()-1));
    }

}
