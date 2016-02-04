package org.dedda.bratwurst;

import org.dedda.bratwurst.lang.*;
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
    }

    private BWInstruction[] getInstructions() {
        return new BWInstruction[]{
                new ClassRegistration(getPointClass()),
                new VariableDeclaration(0, "point1", new ObjectCreation(0, "Point")),
                new FunctionCall(0, "point1", "setX", new BWVariable[]{new BWVariable("newX", new BWInteger(65))}),
                new FunctionCall(0, "point1", "setY", new BWVariable[]{new BWVariable("newY", new BWInteger(66))}),
                new VariableDeclaration(0, "x", new FunctionCall(0, "point1", "getX", new BWVariable[0])),
                new VariableDeclaration(0, "y", new FunctionCall(0, "point1", "getY", new BWVariable[0])),
                new PrintVariable(0, "x"),
                new PrintVariable(0, "y"),
                new FunctionCall(0, "point1", "setLocation", new BWVariable[]{new BWVariable("newX", new BWInteger(67)), new BWVariable("newY", new BWInteger(68))}),
                new VariableDeclaration(0, "x", new FunctionCall(0, "point1", "getX", new BWVariable[0])),
                new VariableDeclaration(0, "y", new FunctionCall(0, "point1", "getY", new BWVariable[0])),
                new PrintVariable(0, "x"),
                new PrintVariable(0, "y"),
                new Exit(0)
        };
    }

    private BWClass getPointClass() {
        BWFunction[] functions = new BWFunction[]{
                new BWFunction("setX", new BWInstruction[]{
                        new VariableDeclaration(0, "x", new ReadVariable(0, "newX"))
                }),
                new BWFunction("setY", new BWInstruction[]{
                        new VariableDeclaration(0, "y", new ReadVariable(0, "newY"))
                }),
                new BWFunction("setLocation", new BWInstruction[]{
                        new VariableDeclaration(0, "x", new ReadVariable(0, "newX")),
                        new VariableDeclaration(0, "y", new ReadVariable(0, "newY"))
                }),
                new BWFunction("getX", new BWInstruction[]{
                        new Return(0, new ReadVariable(0, "x"))
                }),
                new BWFunction("getY", new BWInstruction[]{
                        new Return(0, new ReadVariable(0, "y"))
                })
        };
        return new BWClass("Point", functions);
    }

}
