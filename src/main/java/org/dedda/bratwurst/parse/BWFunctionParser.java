package org.dedda.bratwurst.parse;

import org.dedda.bratwurst.lang.BWFunction;
import org.dedda.bratwurst.lang.BWInstruction;

import java.util.LinkedList;
import java.util.List;

import static org.dedda.bratwurst.parse.Patterns.*;

/**
 * Created by dedda on 10/17/15.
 *
 * @author dedda
 */
public class BWFunctionParser {

    /**
     *
     * @param lines Lines of code which also contain the code for the function to parse.
     * @param begin Index of the line that indicates the beginning of the function (~{).
     * @return Parsed {@link BWFunction}
     */
    public BWFunction parse(String[] lines, int begin) {
        if (!lines[begin].matches(FUNCTION_BEGIN)) {
            throw new RuntimeException("invalid function begin, no head found!");
        }
        int end = getEndOfFunction(lines, begin);
        String functionName = null;
        List<BWInstruction> instructions = new LinkedList<>();
        InstructionParser instructionParser = new InstructionParser();
        ConditionParser conditionParser = new ConditionParser();
        LoopParser loopParser = new LoopParser();
        for (int i = begin+1; i < end; i++) {
            String line = lines[i];
            if (line.matches(NAMING)) {
                functionName = line.split(" ")[2];
            } else if (line.matches(CONDITION_HEAD)) {
                int conditionEnd = conditionParser.getEnd(lines, i);
                instructions.add(conditionParser.parse(lines, i));
                i = conditionEnd;
            } else if (line.matches(LOOP_HEAD)) {
                int loopEnd = loopParser.getEnd(lines, i);
                instructions.add(loopParser.parse(lines, i));
                i = loopEnd;
            } else {
                instructions.add(instructionParser.parse(line, i));
            }
        }
        if (functionName == null) {
            throw new RuntimeException("function name not defined!");
        }
        BWInstruction[] instructionsArray = new BWInstruction[instructions.size()];
        instructions.toArray(instructionsArray);
        return new BWFunction(functionName, instructionsArray);
    }

    public int getEndOfFunction(String[] lines, int begin) {
        for (int i = begin+1; i < lines.length; i++) {
            String line = lines[i];
            if (line.matches(FUNCTION_END)) {
                return i;
            }
        }
        throw new RuntimeException("End of method not found!");
    }

}
