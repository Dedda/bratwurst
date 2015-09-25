package org.dedda.bratwurst.parse;

import org.dedda.bratwurst.lang.Program;

import java.io.File;

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
}
