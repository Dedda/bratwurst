package org.dedda.bratwurst;

import org.dedda.bratwurst.lang.Program;
import org.dedda.bratwurst.parse.Parser;
import org.dedda.bratwurst.test.TestSuite;

import java.io.File;

/**
 * Created by dedda on 9/25/15.
 *
 * @author dedda
 */
public class Main {

    public static void main(String[] args) {
        if (isTestMode(args)) {
            String testSuiteFile = getTestSuite(args);
            TestSuite testSuite = new TestSuite(testSuiteFile);
            testSuite.run();
        } else {
            if (args.length != 1) {
                throw new RuntimeException("No program file given!");
            }
            String fileName = args[0];
            File file = new File(fileName);
            if (!file.exists()) {
                throw new RuntimeException("Cannot find file!");
            }
            Parser parser = new Parser(file);
            Program program = parser.parse();
            program.run();

            int exitCode = program.getExitCode();
            System.out.println("Program exited with code " + exitCode);
        }
    }

    private static boolean isTestMode(String[] args) {
        for (String arg : args) {
            if (arg.equals("-t")) {
                return true;
            }
        }
        return false;
    }

    private static String getTestSuite(String[] args) {
        for (int i = 0; i < args.length - 1; i++) {
            if (args[i].equals("--test-suite")) {
                return args[i + 1];
            }
        }
        return null;
    }

}
