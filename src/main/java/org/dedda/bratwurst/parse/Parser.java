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

import static org.dedda.bratwurst.parse.Patterns.*;

/**
 * Created by dedda on 9/25/15.
 *
 * @author dedda
 */
public class Parser {

    private final File sourceFile;

    public Parser(File sourceFile) {
        this.sourceFile = sourceFile;
    }

    public Program parse() {
        String[] lines;
        try {
            lines = getFileContents(sourceFile).split("\n");
        } catch (IOException e) {
            throw new RuntimeException("can't load source file!", e);
        }
        for (int i = 0; i < lines.length; i++) {
            lines[i] = lines[i].trim();
        }
        while (Arrays.stream(lines).filter(l -> l.matches(INCLUDE)).findFirst().isPresent()) {
            for (int i = 0; i < lines.length; i++) {
                if (lines[i].matches(INCLUDE)) {
                    try {
                        String[] included = getFileContents(new File(sourceFile.getParent() + '/' + lines[i].substring(1, lines[i].length()-1))).split("\n");
                        lines = insertIntoArray(lines, included, i);
                        break;
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        if (!lines[0].matches(BEGIN)) {
            throw new RuntimeException("HELP! FIRST INSTRUCTION IS NOT AN ENTRY POINT! WHAT DO?!");
        }
        List<BWInstruction> instructions = new LinkedList<>();
        List<BWFunction> functions = new LinkedList<>();
        List<BWClass> classes = new LinkedList<>();
        InstructionParser instructionParser = new InstructionParser();
        BWFunctionParser functionParser = new BWFunctionParser();
        BWClassParser classParser = new BWClassParser();
        ConditionParser conditionParser = new ConditionParser();
        LoopParser loopParser = new LoopParser();
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
                    continue;
                }
            } else {
                instructions.add(instruction);
            }
        }
        BWInstruction[] instructionsArray = new BWInstruction[instructions.size()];
        instructions.toArray(instructionsArray);
        BWFunction[] functionsArray = new BWFunction[functions.size()];
        functions.toArray(functionsArray);
        BWClass[] classesArray = new BWClass[classes.size()];
        classes.toArray(classesArray);
        Program program = new Program();
        program.setInstructions(instructionsArray);
        program.setFunctions(functionsArray);
        program.setClasses(classesArray);
        return program;
    }

    private String getFileContents(final File file) throws IOException {
        long size = file.length();
        char buffer[] = new char[(int) size];
        new FileReader(file).read(buffer);
        return new String(buffer);
    }

    public String[] insertIntoArray(String[] array, String[] toInsert, int lineToReplace) {
        String[] newArray = new String[array.length + toInsert.length - 1];
        for (int i = 0; i < lineToReplace; i++) {
            newArray[i] = array[i];
        }
        for (int i = lineToReplace; i < lineToReplace + toInsert.length; i++) {
            newArray[i] = toInsert[i - lineToReplace];
        }
        for (int i = lineToReplace + toInsert.length; i < newArray.length; i++) {
            newArray[i] = array[i - toInsert.length + 1];
        }
        return newArray;
    }

}
