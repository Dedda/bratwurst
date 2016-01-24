package org.dedda.bratwurst;

import org.dedda.bratwurst.lang.*;
import org.dedda.bratwurst.parse.Parser;
import org.dedda.bratwurst.test.TestFileRunner;
import org.dedda.bratwurst.test.TestSuite;

import java.io.File;

/**
 * Created by dedda on 9/25/15.
 *
 * @author dedda
 */
public class Main {

    public static void main(String[] args) {
        TestSuite testSuite = new TestSuite("src/test/testSuite.bw");
        testSuite.run();
//        TestFileRunner runner = new TestFileRunner(filename);
//        runner.run();



//        if (args.length != 1) {
//            throw new RuntimeException("No program file given!");
//        }
//        String fileName = args[0];
//        File file = new File(fileName);
//        if (!file.exists()) {
//            throw new RuntimeException("Cannot find file!");
//        }
//        Parser parser = new Parser(file);
//        Program program = parser.parse();
//        program.run();
//
//        int exitCode = program.getExitCode();
//        System.out.println("Program exited with code " + exitCode);




//        new TestProgram();
//        Program.getInstance().run();
    }

}
