package org.dedda.bratwurst.test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dedda on 1/24/16.
 *
 * @author dedda
 */
public class TestSuite {

    private List<String> testFiles;

    public TestSuite() {
        testFiles = new ArrayList<>();
    }

    public TestSuite(String suiteFile) {
        File file = new File(suiteFile);
        if (!file.exists()) {
            throw new RuntimeException("suite file not found!");
        }
        testFiles = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                testFiles.add(file.getParent() + "/" + line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public TestSuite(List<String> testFiles) {
        this.testFiles = testFiles;
    }

    public boolean run() {
        boolean success = true;
        int assertions = 0;
        System.out.println("Running test suite with test files: ");
        for (String file : testFiles) {
            System.out.println(" - " + file);
        }
        for (String file : testFiles) {
            TestFileRunner runner = new TestFileRunner(file);
            runner.run();
            assertions += runner.getAllAssertions();
            if (!runner.wasSuccessful()) {
                success = false;
            }
        }
        System.out.println("======================================");
        System.out.println(assertions + " assertions in test suite");
        if (!success) {
            System.out.println("failures!");
        }
        return success;
    }

    public void addFile(String filename) {
        this.testFiles.add(filename);
    }

}
