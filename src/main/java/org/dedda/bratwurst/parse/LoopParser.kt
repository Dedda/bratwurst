package org.dedda.bratwurst.parse;

import org.dedda.bratwurst.lang.BWExpression;
import org.dedda.bratwurst.lang.BWInstruction;
import org.dedda.bratwurst.lang.Loop;

import java.util.LinkedList;
import java.util.List;

import static org.dedda.bratwurst.parse.Patterns.LOOP_END;

/**
 * Created by dedda on 10/19/15.
 *
 * @author dedda
 */
public class LoopParser {

    public Loop parse(final String[] lines, final int begin) {
        final int end = getEnd(lines, begin);
        final BWExpression head = new ExpressionParser().parse(lines[begin].substring(2, lines[begin].length()-1), begin);
        final List<BWInstruction> instructions = new LinkedList<>();
        for (int i = begin+1; i < end; i++) {
            instructions.add(new InstructionParser().parse(lines[i], i));
        }
        final BWInstruction[] instructionsArray = new BWInstruction[instructions.size()];
        instructions.toArray(instructionsArray);
        return new Loop(begin, head, instructionsArray);
    }

    public int getEnd(final String[] lines, final int begin) {
        for (int i = begin; i < lines.length; i++) {
            if (lines[i].matches(LOOP_END)) {
                return i;
            }
        }
        throw new RuntimeException("No loop end found!");
    }

}
