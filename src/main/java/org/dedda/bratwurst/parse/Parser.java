package org.dedda.bratwurst.parse;

import org.dedda.bratwurst.lang.BWClass;
import org.dedda.bratwurst.lang.Program;
import org.dedda.bratwurst.lang.instruction.Print;
import org.dedda.bratwurst.lang.instruction.RegisterClass;
import org.dedda.bratwurst.lang.instruction.VariableDeclaration;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import static org.dedda.bratwurst.parse.Patterns.PRINT;
import static org.dedda.bratwurst.parse.Patterns.VARIABLE_DECLARATION;

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

    public Program parse() {
        String sourceCode;
        try {
            sourceCode = getFileContents(this.sourceFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        int currentLine = 0;
        String lines[] = sourceCode.split("\n");
        while (currentLine < lines.length) {
            String line = lines[currentLine];
            if (line.matches(Patterns.CLASS_BEGIN)) {
                int end = getClassEndLine(lines, currentLine);
                BWClass bwClass = new BWClassParser().parseClass(lines, currentLine);
                RegisterClass instruction = new RegisterClass(bwClass);
                Program.getInstance().addInstruction(instruction);
                currentLine = end + 1;
                continue;
            }
            if (line.matches(VARIABLE_DECLARATION)) {
                VariableDeclaration declaration = new BWVariableParser().parseDeclaration(line);
                Program.getInstance().addInstruction(declaration);
                currentLine++;
                continue;
            }
            if (line.matches(PRINT)) {
                Print print = new PrintParser().parse(line);
                Program.getInstance().addInstruction(print);
                currentLine++;
                continue;
            }
        }
        return this.program;
    }

    private String getFileContents(final File file) throws IOException {
        long size = file.length();
        char buffer[] = new char[(int) size];
        new FileReader(file).read(buffer);
        return new String(buffer);
    }

    public boolean isInstruction(final String line) {
        return true;
    }

    public boolean isVariableDeclaration(final String line) {
        String trimmed = line;
        String split[] = trimmed.split(" ");
        if (!split[0].matches("\\((w+)\\)")) {
            return false;
        }
        if (!split[1].equals("<--")) {
            return false;
        }
        if (split.length < 3) {
            return false;
        }
        return true;
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
