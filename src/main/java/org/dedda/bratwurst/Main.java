package org.dedda.bratwurst;

import org.dedda.bratwurst.lang.*;
import org.dedda.bratwurst.parse.Emoji;
import org.dedda.bratwurst.parse.Parser;

import java.io.File;

/**
 * Created by dedda on 9/25/15.
 *
 * @author dedda
 */
public class Main {

    public static void main(String[] args) {

        System.out.println(Emoji.ALIEN);
        System.out.println(Emoji.ALL_OK);
        System.out.println(Emoji.GHOST);
        System.out.println(Emoji.ANGEL_FACE);
        System.out.println(Emoji.BOMB);
        System.out.println(Emoji.FLEX);

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
