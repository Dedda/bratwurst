package org.dedda.bratwurst.parse;

import com.sun.org.apache.bcel.internal.generic.Instruction;
import org.dedda.bratwurst.lang.BWClass;
import org.dedda.bratwurst.lang.BWFunction;
import org.dedda.bratwurst.lang.BWInstruction;
import org.dedda.bratwurst.lang.Program;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.dedda.bratwurst.parse.Patterns.BEGIN;
import static org.dedda.bratwurst.parse.Patterns.CLASS_BEGIN;
import static org.dedda.bratwurst.parse.Patterns.END;
import static org.dedda.bratwurst.parse.Patterns.FUNCTION_BEGIN;
import static org.dedda.bratwurst.parse.Patterns.PRINT;

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

    public void parse() {
        String[] lines;
        try {
            lines = getFileContents(sourceFile).split("\n");
        } catch (IOException e) {
            throw new RuntimeException("can't load source file!", e);
        }
        for (int i = 0; i < lines.length; i++) {
            lines[i] = lines[i].trim();
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
        Program.getInstance().setInstructions(instructionsArray);
        Program.getInstance().setFunctions(functionsArray);
        Program.getInstance().setClasses(classesArray);
    }

    private String getFileContents(final File file) throws IOException {
        long size = file.length();
        char buffer[] = new char[(int) size];
        new FileReader(file).read(buffer);
        return new String(buffer);
    }

}
