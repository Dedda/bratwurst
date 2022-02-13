package org.dedda.bratwurst.parse;

import org.dedda.bratwurst.lang.BWExpression;
import org.dedda.bratwurst.lang.BWInstruction;
import org.dedda.bratwurst.lang.Condition;

import java.util.LinkedList;
import java.util.List;

import static org.dedda.bratwurst.parse.Patterns.CONDITION_END;
import static org.dedda.bratwurst.parse.Patterns.CONDITION_SEPARATOR;

/**
 * Created by dedda on 10/19/15.
 *
 * @author dedda
 */
public class ConditionParser {

    public Condition parse(final String[] lines, final int begin) {
        final int end = getEnd(lines, begin);
        final int separator = getSeparator(lines, begin);
        final String conditionLine = lines[begin];
        final List<BWInstruction> trueInstructions = new LinkedList<>();
        final List<BWInstruction> falseInstructions = new LinkedList<>();
        for (int i = begin+1; i < separator; i++) {
            trueInstructions.add(new InstructionParser().parse(lines[i], i));
        }
        for (int i = separator+1; i < end; i++) {
            falseInstructions.add(new InstructionParser().parse(lines[i], i));
        }
        final BWExpression condition = new ExpressionParser().parse(conditionLine.substring(2, conditionLine.length() - 3), begin);
        final BWInstruction[] trueInstructionsArray = new BWInstruction[trueInstructions.size()];
        trueInstructions.toArray(trueInstructionsArray);
        final BWInstruction[] falseInstructionsArray = new BWInstruction[falseInstructions.size()];
        falseInstructions.toArray(falseInstructionsArray);
        return new Condition(begin, condition, trueInstructionsArray, falseInstructionsArray);
    }

    public int getEnd(final String[] lines, final int begin) {
        for (int i = begin; i < lines.length; i++) {
            if (lines[i].matches(CONDITION_END)) {
                return i;
            }
        }
        throw new RuntimeException("No condition end found!");
    }

    private int getSeparator(final String[] lines, final int begin) {
        for (int i = begin; i < lines.length; i++) {
            if (lines[i].matches(CONDITION_SEPARATOR)) {
                return i;
            }
        }
        throw new RuntimeException("No condition separator found!");
    }

}
