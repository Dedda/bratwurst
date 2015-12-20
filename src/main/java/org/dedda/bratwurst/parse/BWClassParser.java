package org.dedda.bratwurst.parse;

import org.dedda.bratwurst.lang.BWClass;
import org.dedda.bratwurst.lang.BWFunction;

import java.util.LinkedList;
import java.util.List;

import static org.dedda.bratwurst.parse.Emoji.DIAMOND;
import static org.dedda.bratwurst.parse.Emoji.DOCTOR_MASK;
import static org.dedda.bratwurst.parse.Patterns.CLASS_END;
import static org.dedda.bratwurst.parse.Patterns.FUNCTION_BEGIN;
import static org.dedda.bratwurst.parse.Patterns.CLASS_NAMING;
import static org.dedda.bratwurst.parse.Patterns.VARIABLE_DECLARATION;

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
        for (int i = 0; i < end; i++) {
            String line = lines[i];
            if (line.matches(CLASS_NAMING)) {
                className = line.substring(DOCTOR_MASK.length(), line.length() -  DIAMOND.length());
                continue;
            }
            if (line.matches(FUNCTION_BEGIN)) {
                functions.add(functionParser.parse(lines, i));
                int functionEnd = functionParser.getEndOfFunction(lines, i);
                i = functionEnd;
                continue;
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
