package org.dedda.bratwurst.parse;

import com.sun.org.apache.bcel.internal.generic.Instruction;
import org.dedda.bratwurst.lang.BWInstruction;
import org.dedda.bratwurst.lang.Program;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import static org.dedda.bratwurst.parse.Patterns.CLASS_BEGIN;
import static org.dedda.bratwurst.parse.Patterns.FUNCTION_BEGIN;
import static org.dedda.bratwurst.parse.Patterns.PRINT;

/**
 * Created by dedda on 9/25/15.
 *
 * @author dedda
 */
public class Parser {

    private final File sourceFile;
    private Program program;

    public Parser(File sourceFile) {
        this(sourceFile, Program.getInstance());
    }

    public Parser(File sourceFile, Program program) {
        this.sourceFile = sourceFile;
        this.program = program;
    }

    public void parse() {
        String[] lines;
        try {
            lines = getFileContents(sourceFile).split("\n");
        } catch (IOException e) {
            throw new RuntimeException("can't load source file!", e);
        }
        InstructionParser instructionParser = new InstructionParser();
        for (int i = 0; i < lines.length; i++) {
            String line = lines[i];
            BWInstruction instruction = instructionParser.parse(line);
            if (instruction == null) {
                if (line.matches(FUNCTION_BEGIN)) {

                }
                // TODO: not an instruction
            }
        }

    }

    private String getFileContents(final File file) throws IOException {
        long size = file.length();
        char buffer[] = new char[(int) size];
        new FileReader(file).read(buffer);
        return new String(buffer);
    }

    public boolean isClassDeclaration(final String line) {
        return false;
    }

    public int getClassEndLine(final String lines[], final int start) {
        int breacketCounter = 0;
        boolean classStarted = false;
        for (int i = start; i < lines.length; i++) {
            String line = lines[i].trim();
            for (int k = 0; k < line.length(); k++) {
                if (line.charAt(k) == '[') {
                    breacketCounter++;
                    if (k > 0 && line.charAt(k-1) == '#') {
                        classStarted = true;
                    }
                } else if (line.charAt(k) == ']') {
                    breacketCounter--;
                    if (breacketCounter == 0 && classStarted) {
                        return i;
                    }
                }
            }
        }
        return -1;
    }

    public boolean isFunctionDeclaration(final String line) {
        return false;
    }

}
