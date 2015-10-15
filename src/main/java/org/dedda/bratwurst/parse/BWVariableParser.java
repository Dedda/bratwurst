package org.dedda.bratwurst.parse;

import org.dedda.bratwurst.lang.BWInteger;
import org.dedda.bratwurst.lang.VariableDeclaration;

/**
 * Created by dedda on 9/25/15.
 *
 * @author dedda
 */
public class BWVariableParser {

    public VariableDeclaration parseDeclaration(final String line) {
        VariableDeclaration declaration;
        String[] split = line.split(" ");
        if (split[2].matches("(\\d+)")) {
            declaration = new VariableDeclaration(split[0], new BWInteger(Integer.parseInt(split[2])));
        } else {
            declaration = null;
        }
        return declaration;
    }

}
