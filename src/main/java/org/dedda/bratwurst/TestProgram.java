package org.dedda.bratwurst;

import org.dedda.bratwurst.lang.BWClass;
import org.dedda.bratwurst.lang.BWFunction;
import org.dedda.bratwurst.lang.BWInstruction;
import org.dedda.bratwurst.lang.BWInteger;
import org.dedda.bratwurst.lang.BWVariable;
import org.dedda.bratwurst.lang.ClassRegistration;
import org.dedda.bratwurst.lang.Exit;
import org.dedda.bratwurst.lang.FunctionCall;
import org.dedda.bratwurst.lang.ObjectCreation;
import org.dedda.bratwurst.lang.PrintVariable;
import org.dedda.bratwurst.lang.Program;
import org.dedda.bratwurst.lang.ReadVariable;
import org.dedda.bratwurst.lang.Return;
import org.dedda.bratwurst.lang.VariableDeclaration;
import org.dedda.bratwurst.parse.Parser;

import java.io.File;

/**
 * Created by dedda on 10/16/15.
 *
 * @author dedda
 */
public class TestProgram {

    public TestProgram() {
//        Program.getInstance().setInstructions(getInstructions());
        getParsedInstructions();
    }

    private void getParsedInstructions() {
        Parser parser = new Parser(new File("src/test/testprogram.bw"));
        parser.parse();
        System.out.println(Program.getInstance().getInstructions().length);
        System.out.println(Program.getInstance().getFunctions().length);
        System.out.println(Program.getInstance().getClasses().length);
    }

    private BWInstruction[] getInstructions() {
        return new BWInstruction[]{
                new ClassRegistration(getPointClass()),
                new VariableDeclaration("point1", new ObjectCreation("Point")),
                new FunctionCall("point1", "setX", new BWVariable[]{new BWVariable("newX", new BWInteger(65))}),
                new FunctionCall("point1", "setY", new BWVariable[]{new BWVariable("newY", new BWInteger(66))}),
                new VariableDeclaration("x", new FunctionCall("point1", "getX", new BWVariable[0])),
                new VariableDeclaration("y", new FunctionCall("point1", "getY", new BWVariable[0])),
                new PrintVariable("x"),
                new PrintVariable("y"),
                new FunctionCall("point1", "setLocation", new BWVariable[]{new BWVariable("newX", new BWInteger(67)), new BWVariable("newY", new BWInteger(68))}),
                new VariableDeclaration("x", new FunctionCall("point1", "getX", new BWVariable[0])),
                new VariableDeclaration("y", new FunctionCall("point1", "getY", new BWVariable[0])),
                new PrintVariable("x"),
                new PrintVariable("y"),
                new Exit()
        };
    }

    private BWClass getPointClass() {
        BWFunction[] functions = new BWFunction[]{
                new BWFunction("setX", new BWInstruction[]{
                        new VariableDeclaration("x", new ReadVariable("newX"))
                }),
                new BWFunction("setY", new BWInstruction[]{
                        new VariableDeclaration("y", new ReadVariable("newY"))
                }),
                new BWFunction("setLocation", new BWInstruction[]{
                        new VariableDeclaration("x", new ReadVariable("newX")),
                        new VariableDeclaration("y", new ReadVariable("newY"))
                }),
                new BWFunction("getX", new BWInstruction[]{
                        new Return(new ReadVariable("x"))
                }),
                new BWFunction("getY", new BWInstruction[]{
                        new Return(new ReadVariable("y"))
                })
        };
        return new BWClass("Point", functions);
    }

}
