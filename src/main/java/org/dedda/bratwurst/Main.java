package org.dedda.bratwurst;

import org.dedda.bratwurst.lang.*;
import org.dedda.bratwurst.parse.Emoji;
import org.dedda.bratwurst.parse.Parser;

import java.io.File;

import static org.dedda.bratwurst.parse.Emoji.*;

/**
 * Created by dedda on 9/25/15.
 *
 * @author dedda
 */
public class Main {

    public static void main(String[] args) {

//        System.out.println(ALIEN);
//        System.out.println(ALL_OK);
//        System.out.println(GHOST);
//        System.out.println(ANGEL_FACE);
//        System.out.println(BOMB);
//        System.out.println(FLEX);
//        System.out.println(X_X);
//        System.out.println(GHOST);
//        System.out.println(POOP);
//        System.out.println(TURBAN);
//        System.out.println(POODLE);
//        System.out.println(PIG);
//        System.out.println(SNAKE);
//        System.out.println(EXPLOSION);
//        System.out.println(HEART_BIG);
//        System.out.println(GRAND_PA);
//        System.out.println(EVERGREEN);
//        System.out.println(CORN);
//        System.out.println(SQUIRT);
//        System.out.println(BANANA);
//        System.out.println(CACTUS);
//        System.out.println(DOCTOR_MASK);
//        System.out.println(DIAMOND);

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
