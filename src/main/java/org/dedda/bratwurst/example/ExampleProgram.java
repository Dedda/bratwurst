package org.dedda.bratwurst.example;

import org.dedda.bratwurst.lang.*;

import static org.dedda.bratwurst.parse.Emoji.*;

/**
 * Created by dedda on 12/21/15.
 *
 * @author dedda
 */
public class ExampleProgram extends Program {

    public ExampleProgram() {
        super();
        BWClass.unregisterAll();
        this.setClasses(createClasses());
        this.setFunctions(createFunctions());
        this.setInstructions(createInstructions());
    }

    private BWClass[] createClasses() {
        return new BWClass[]{
                new ExampleClass_TULIP_BABY_BEER()
        };
    }

    private BWFunction[] createFunctions() {
        return new BWFunction[]{

        };
    }

    private BWInstruction[] createInstructions() {
        int counter = 0;
        return new BWInstruction[]{
                new VariableDeclaration(counter, BOY + ROSE, new ObjectCreation(++counter, TULIP + BABY + BEER)),
                new VariableDeclaration(counter, WINE + BOY + ROSE, new Instanceof(counter, new ReadVariable(++counter, BOY + ROSE), TULIP + BABY + BEER)),
//                new Condition(counter)
                new PrintInt(++counter, WINE + BOY + ROSE),
                new Exit(++counter)
        };
    }

}
