package org.dedda.bratwurst.parse;

import org.dedda.bratwurst.lang.Program;

import java.awt.Point;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by dedda on 9/25/15.
 *
 * @author dedda
 */
public class Parser {

    private final File sourceFile;
    private Program program;

    public Parser(File sourceFile) {
        this(sourceFile, new Program());
    }

    public Parser(File sourceFile, Program program) {
        this.sourceFile = sourceFile;
        this.program = program;
    }

    public Program parse() {
        String sourceCode = null;
        try {
            sourceCode = getFileContents(this.sourceFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        int currentLine = 0;
        String lines[] = sourceCode.split("\n");
        while (currentLine < lines.length) {

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

    public Point findClassClosing(final int line, final int offset) {
        return new Point(0, 0);
    }

}
