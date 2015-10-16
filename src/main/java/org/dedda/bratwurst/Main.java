package org.dedda.bratwurst;

import org.dedda.bratwurst.lang.*;

/**
 * Created by dedda on 9/25/15.
 *
 * @author dedda
 */
public class Main {

    public static void main(String[] args) {
        new TestProgram();
        Program.getInstance().run();
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
