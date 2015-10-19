package org.dedda.bratwurst.parse;

import org.dedda.bratwurst.lang.ReadVariable;

/**
 * Created by dedda on 10/17/15.
 *
 * @author dedda
 */
public class ReadVariableParser {

    public ReadVariable parse(String data, int lineNumber) {
        data = data.trim();
        return new ReadVariable(lineNumber, data);
    }

}
