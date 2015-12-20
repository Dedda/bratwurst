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

//        printEmojis();

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

    private static void printEmojis() {
        for (String emoji : new String[]{
                "Variable name:",
                SKULL_BONES,
                BOY,
                METAL,
                TIGER,
                OCTOPUS,
                ROSE,
                CLOVER,
                PEAR,
                CHERRIES,
                BREAD,
                HOT_DOG,
                FRIED_SHRIMP,
                COOKIE,
                CANDY,
                WINE,
                TWO_BEERS,
                "Class name:",
                POLICE,
                CROWN,
                UNICORN,
                BABY_CHICK,
                TULIP,
                PALM,
                HAMBURGER,
                SPAGHETTI,
                CAKE_PIECE,
                BEER,
                BABY,
                MAN,
                WATER_MELON,
                COOL_FACE,
                NERD,
                "Function name:",
                SMIRKING,
                MEH,
                CAT_HEART_EYES,
                SPOCK,
                SPIDER,
                ELEPHANT,
                TREE_REGULAR,
                SUSHI,
                SOFT_ICE,
                BABY_BOTTLE,
                LOLLIPOP,
                DONUT,
                "String:",
                CHURCH,
                POST_OFFICE,
                LOVE_HOTEL,
                ROLLER_COASTER,
                METRO,
                POLICE_CAR,
                TRUCK_2,
                ANCHOR,
                SAILING_BOAT,
                YACHT,
                PLANE,
                DOOR,
                TOILET,
                "======",
                ALIEN,
                ALL_OK,
                GHOST,
                ANGEL_FACE,
                BOMB,
                FLEX,
                CACTUS,
                DOCTOR_MASK,
                DIAMOND,
                SNAKE,
                TURBAN,
                X_X,
                PIG,
                EVERGREEN,
                CORN,
                SQUIRT,
                BANANA,
                EXPLOSION,
                HEART_BIG,
                GRAND_PA,
                LEMON,
                SANTA,
                PINEAPPLE,
                MONKEY_FACE,
                POODLE,
                POOP
        }) {
            System.out.println(emoji);
        }
    }

}
