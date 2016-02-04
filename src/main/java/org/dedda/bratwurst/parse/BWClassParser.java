package org.dedda.bratwurst.parse;

import org.dedda.bratwurst.lang.BWClass;
import org.dedda.bratwurst.lang.BWFunction;

import java.util.LinkedList;
import java.util.List;

import static org.dedda.bratwurst.parse.Patterns.*;

/**
 * Created by dedda on 9/25/15.
 *
 * @author dedda
 */
public class BWClassParser {

    public BWClass parse(String[] lines, int begin) {
        int end = getEnd(lines, begin);
        for (int i = 0; i < lines.length; i++) {
            lines[i] = lines[i].trim();
        }
        String className = null;
        List<BWFunction> functions = new LinkedList<>();
        BWFunctionParser functionParser = new BWFunctionParser();
        for (int i = begin; i < end; i++) {
            String line = lines[i];
            if (line.matches(NAMING)) {
                className = line.split(" ")[2];
                continue;
            }
            if (line.matches(FUNCTION_BEGIN)) {
                functions.add(functionParser.parse(lines, i));
                i = functionParser.getEndOfFunction(lines, i);
            }
        }
        if (className == null) {
            throw new RuntimeException("class name not found!");
        }
        BWFunction[] functionsArray = new BWFunction[functions.size()];
        functions.toArray(functionsArray);
        return new BWClass(className, functionsArray);
    }

    public int getEnd(String[] lines, int begin) {
        for (int i = begin; i < lines.length; i++) {
            if (lines[i].trim().matches(CLASS_END)) {
                return i;
            }
        }
        throw new RuntimeException("no class end found!");
    }

}
