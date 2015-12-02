package org.dedda.bratwurst;

import org.dedda.bratwurst.lang.*;
import org.dedda.bratwurst.parse.Parser;

import java.io.File;

/**
 * Created by dedda on 9/25/15.
 *
 * @author dedda
 */
public class Main {

    public static void main(String[] args) {
        if (args.length != 1) {
            throw new RuntimeException("No program file given!");
        }
        String fileName = args[0];
        File file = new File(fileName);
        if (!file.exists()) {
            throw new RuntimeException("Cannot find file!");
        }
        Parser parser = new Parser(file);
        parser.parse();
        Program.getInstance().run();

        int exitCode = Program.getInstance().getExitCode();
        System.out.println("Program exited with code " + exitCode);

//        new TestProgram();
//        Program.getInstance().run();
    }

}
