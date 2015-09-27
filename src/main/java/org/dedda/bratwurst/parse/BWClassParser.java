package org.dedda.bratwurst.parse;

import org.dedda.bratwurst.lang.BWClass;

/**
 * Created by dedda on 9/25/15.
 *
 * @author dedda
 */
public class BWClassParser extends Parser {

    public BWClassParser() {
        super(null);
    }

    public BWClass parseClass(final String lines[], final int linenumber) {
        BWClass bwClass = new BWClass();
        int lastLine = getClassEndLine(lines, linenumber);
        String classLines[] = new String[lastLine - linenumber + 1];
        for (int i = linenumber, k = 0; i <= lastLine; i++, k++) {
            classLines[k] = lines[i];
        }

        return bwClass;
    }

}
