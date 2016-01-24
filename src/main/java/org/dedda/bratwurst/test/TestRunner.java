package org.dedda.bratwurst.test;

import org.dedda.bratwurst.lang.BWFunction;
import org.dedda.bratwurst.lang.Program;
import org.dedda.bratwurst.parse.Parser;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by dedda on 1/23/16.
 *
 * @author dedda
 */
public class TestRunner {

    public final String fileName;
    private int assertions = 0;
    private int allAssertions = 0;
    private boolean stop;

    public TestRunner(String fileName) {
        this.fileName = fileName;
    }

    public void run() {
        File file = new File(fileName);
        Parser parser = new Parser(file);
        Program program = parser.parse();
        BWFunction[] functions = program.getFunctions();
        List<BWFunction> testFunctions = Arrays.stream(functions).filter(f -> f.getName().startsWith("test")).collect(Collectors.toList());
        System.out.println(testFunctions.size() + " test functions found\n");
        for (BWFunction function : testFunctions) {
            assertions = 0;
            System.out.println("running " + function.getName() + ":");
            new TestFunctionRunner().run(this, fileName, function.getName());
            if (stop) {
                break;
            }
            System.out.println(" [" + assertions + "] assertions.");
        }
        System.out.println("\n" + allAssertions + " assertions");
        if (stop) {
            System.out.println("failures!");
        }
    }

    public void incAssertions() {
        assertions++;
        allAssertions++;
    }

    public void stop() {
        stop = true;
    }

}
