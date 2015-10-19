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
//        new TestProgram();
//        Program.getInstance().run();
        /*BWFunction[] functions = new BWFunction[1];
        BWClass[] classes = new BWClass[0];
        BWVariable[] variables = new BWVariable[0];
        BWInstruction[] instructions = new BWInstruction[0];

        BWInstruction[] function0Instructions = new BWInstruction[2];
        function0Instructions[0] = new PrintChar('A');
        function0Instructions[1] = new PrintChar('B');
        functions[0] = new BWFunction("function", function0Instructions);

        Program.getInstance().setFunctions(functions);
        Program.getInstance().setClasses(classes);
        Program.getInstance().setVariables(variables);
        Program.getInstance().setInstructions(instructions);
        Program.getInstance().run();*/
    }

}
