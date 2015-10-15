package org.dedda.bratwurst.parse;

import org.dedda.bratwurst.lang.AbstractFunction;
import org.dedda.bratwurst.lang.BWClass;
import org.dedda.bratwurst.lang.BWFunction;

import java.util.LinkedList;
import java.util.List;

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
        String className = null;
        int lastLine = getClassEndLine(lines, linenumber);
        String classLines[] = new String[lastLine - linenumber + 1];
        for (int i = linenumber, k = 0; i <= lastLine; i++, k++) {
            classLines[k] = lines[i];
        }
        boolean inFunction = false;
        List<String> functionLines = new LinkedList<>();
        List<BWFunction> functions = new LinkedList<>();
        for (int i = 0; i < classLines.length; i++) {
            String line = classLines[i];
            if (inFunction) {
                if (line.matches(Patterns.FUNCTION_BEGIN)) {
                    throw new RuntimeException("function declaration inside function!");
                }
                if (line.matches(Patterns.FUNCTION_END)) {
                    BWFunction function = createFunction(functionLines);
                    functions.add(function);
                    inFunction = false;
                    continue;
                }
                functionLines.add(line);
            } else {
                if (line.matches(Patterns.FUNCTION_BEGIN)) {
                    inFunction = true;
                }
                if (line.matches(Patterns.NAMING)) {
                    if (className == null) {
                        className = extractName(line);
                    } else {
                        throw new RuntimeException("class already named");
                    }
                }
            }
        }
        return new BWClass(className, new AbstractFunction[0]);
    }

    private String extractName(final String line) {
        return line.split(" ")[2];
    }

    private BWFunction createFunction(final List<String> lines) {
        return null;
    }

}
