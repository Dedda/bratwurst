package org.dedda.bratwurst.parse;

import org.dedda.bratwurst.lang.BWClass;
import org.dedda.bratwurst.lang.BWFunction;
import org.dedda.bratwurst.lang.BWInstruction;
import org.dedda.bratwurst.lang.Program;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;

import static org.dedda.bratwurst.parse.Patterns.*;

/**
 * Created by dedda on 9/25/15.
 *
 * @author dedda
 */
public class Parser {

    private final File sourceFile;
    private final Predicate<String> isInclude = line -> line.matches(INCLUDE);

    /*
     * Parsers:
     */
    private InstructionParser instructionParser = new InstructionParser();
    private BWFunctionParser functionParser = new BWFunctionParser();
    private BWClassParser classParser = new BWClassParser();
    private ConditionParser conditionParser = new ConditionParser();
    private LoopParser loopParser = new LoopParser();

    public Parser(File sourceFile) {
        this.sourceFile = sourceFile;
    }

    public Program parse() {
        String[] lines;
        try {
            lines = getFileContents(sourceFile).split("\n");
        } catch (final IOException e) {
            throw new RuntimeException("can't load source file!", e);
        }
        for (int i = 0; i < lines.length; i++) {
            lines[i] = lines[i].trim();
        }
        while (Arrays.stream(lines).anyMatch(isInclude)) {
            for (int i = 0; i < lines.length; i++) {
                if (isInclude.test(lines[i])) {
                    try {
                        final String[] included = getFileContents(new File(sourceFile.getParent() + '/' + lines[i].substring(1, lines[i].length() - 1))).split("\n");
                        lines = insertIntoArray(lines, included, i);
                        break;
                    } catch (final IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        int counter = 1;
        while (counter < lines.length) {
            if (lines[counter].matches(BEGIN)) {
                lines = removeFromArray(lines, counter);
            }
            counter++;
        }
        counter = 1;
        while (counter < lines.length) {
            boolean removed = false;
            if (lines[counter].trim().length() == 0) {
                removed = true;
                lines = removeFromArray(lines, counter);
            }
            if (!removed) {
                counter++;
            }
        }
        counter = 1;
        while (counter < lines.length) {
            boolean removed = false;
            if (lines[counter].trim().matches(COMMENT)) {
                removed = true;
                lines = removeFromArray(lines, counter);
            }
            if (!removed) {
                counter++;
            }
        }
        if (!lines[0].matches(BEGIN)) {
            throw new RuntimeException("HELP! FIRST INSTRUCTION IS NOT AN ENTRY POINT! WHAT DO?!");
        }
        final List<BWInstruction> instructions = new LinkedList<>();
        final List<BWFunction> functions = new LinkedList<>();
        final List<BWClass> classes = new LinkedList<>();
        for (int i = 0; i < lines.length; i++) {
            String line = lines[i];
            BWInstruction instruction = instructionParser.parse(line, i);
            if (instruction == null) {
                if (line.matches(CLASS_BEGIN)) {
                    int end = classParser.getEnd(lines, i);
                    classes.add(classParser.parse(lines, i));
                    i = end;
                    continue;
                }
                if (line.matches(FUNCTION_BEGIN)) {
                    int end = functionParser.getEndOfFunction(lines, i);
                    functions.add(functionParser.parse(lines, i));
                    i = end;
                    continue;
                }
                if (line.matches(CONDITION_HEAD)) {
                    int end = conditionParser.getEnd(lines, i);
                    instructions.add(conditionParser.parse(lines, i));
                    i = end;
                    continue;
                }
                if (line.matches(LOOP_HEAD)) {
                    int end = loopParser.getEnd(lines, i);
                    instructions.add(loopParser.parse(lines, i));
                    i = end;
                }
            } else {
                instructions.add(instruction);
            }
        }
        final BWInstruction[] instructionsArray = new BWInstruction[instructions.size()];
        instructions.toArray(instructionsArray);
        final BWFunction[] functionsArray = new BWFunction[functions.size()];
        functions.toArray(functionsArray);
        final BWClass[] classesArray = new BWClass[classes.size()];
        classes.toArray(classesArray);
        final Program program = new Program();
        program.setInstructions(instructionsArray);
        program.setFunctions(functionsArray);
        program.setClasses(classesArray);
        return program;
    }

    private String getFileContents(final File file) throws IOException {
        final long size = file.length();
        final char[] buffer = new char[(int) size];
        new FileReader(file).read(buffer);
        return new String(buffer);
    }

    public String[] insertIntoArray(final String[] array, final String[] toInsert, final int lineToReplace) {
        final String[] newArray = new String[array.length + toInsert.length - 1];
        System.arraycopy(array, 0, newArray, 0, lineToReplace);
        System.arraycopy(toInsert, 0, newArray, lineToReplace, toInsert.length);
        System.arraycopy(array, lineToReplace + 1, newArray, lineToReplace + toInsert.length, newArray.length - (lineToReplace + toInsert.length));
        return newArray;
    }

    private String[] removeFromArray(final String[] array, final int index) {
        final String[] newArray = new String[array.length - 1];
        for (int i = 0, n = 0; i < array.length; i++) {
            if (i != index) {
                newArray[n] = array[i];
                n++;
            }
        }
        return newArray;
    }

    public InstructionParser getInstructionParser() {
        return instructionParser;
    }

    public void setInstructionParser(final InstructionParser instructionParser) {
        this.instructionParser = instructionParser;
    }
}
