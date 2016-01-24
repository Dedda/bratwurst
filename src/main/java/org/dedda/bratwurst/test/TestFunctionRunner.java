package org.dedda.bratwurst.test;

import org.dedda.bratwurst.lang.BWClass;
import org.dedda.bratwurst.lang.BWFunction;
import org.dedda.bratwurst.lang.Program;
import org.dedda.bratwurst.lang.scope.Scope;
import org.dedda.bratwurst.parse.Parser;

import java.io.File;
import java.util.Arrays;
import java.util.Optional;

/**
 * Created by dedda on 1/23/16.
 *
 * @author dedda
 */
public class TestFunctionRunner {

    private TestRunner runner;

    public void run(TestRunner runner, String filename, String functionName) {
        this.runner = runner;
        BWClass.unregisterAll();
        Parser parser = new Parser(new File(filename));
        Program program = parser.parse();
        Optional<BWFunction> fopt = Arrays.stream(program.getFunctions()).filter(f -> f.getName().equals(functionName)).findFirst();
        if (!fopt.isPresent()) {
            fail("Function " + functionName + "doesn't exist!");
        }
        BWFunction function = fopt.get();
        Scope scope = new Scope(program, runner, this);
        function.run(scope);

    }

    public void fail(String message) {
        System.out.println(message);
        runner.stop();
    }

}
