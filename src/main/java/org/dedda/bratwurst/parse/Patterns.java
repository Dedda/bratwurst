package org.dedda.bratwurst.parse;

import static org.dedda.bratwurst.parse.Emoji.*;

/**
 * Created by dedda on 9/28/15.
 *
 * @author dedda
 */
public class Patterns {

    public static final String BEGIN = "^" + ALIEN + "$";
    public static final String END = "^" + ALL_OK + "$";

    public static final String CLASS_BEGIN = "^" + GHOST + "$";
    public static final String CLASS_END = "^" + ANGEL_FACE + "$";

    public static final String FUNCTION_BEGIN = "^" + BOMB + "$";
    public static final String FUNCTION_END = "^" + FLEX + "$";
    public static final String FUNCTION_PARAM_FIRST = "@ (\\w+) <-- (\\w+)";

    public static final String FUNCTION_PARAM_OTHERS = "& (\\w+) <-- (\\w+)";
    public static final String FUNCTION_CALL_NOT_TERMINAL = "(\\w*)\\{(\\w+)\\}( " + FUNCTION_PARAM_FIRST + ")?( " + FUNCTION_PARAM_OTHERS + ")*";
    public static final String FUNCTION_CALL = FUNCTION_CALL_NOT_TERMINAL + "$";

    public static final String CALCULATION_PARAMETER = "((\\-?\\d+)|" + validVariableNamePattern() + "|(" + FUNCTION_CALL_NOT_TERMINAL + "))";

    public static final String CALCULATION = CALCULATION_PARAMETER + " [\\+\\-\\*\\/] " + CALCULATION_PARAMETER;

    public static final String TYPE_CHECK = "^" + validVariableNamePattern() + " " + CACTUS + " \\w+$";
    public static final String CLASS_INSTANTIATION = "\\[(\\w+)\\]$";
    public static final String VARIABLE_DECLARATION = "^\\(" + validVariableNamePattern() + "\\) <-- .*$";

    public static final String NAMING = "^" + DOCTOR_MASK + "\\w+" + DIAMOND + "$";

    public static final String INCLUDE = "^%(\\w+[\\w\\.]+)%$";
    public static final String PRINT_VAR = SNAKE + "(" + validVariableNamePattern() + ")" + TURBAN;
    public static final String PRINT_INT = X_X + "((\\-?\\d+)|.|(" + validVariableNamePattern() + "))" + PIG;

    public static final String PRINT = "^(" + PRINT_VAR + ")|(" + PRINT_INT + ")$";

    public static final String RETURN = "^(" + validVariableNamePattern() + "|(" + FUNCTION_CALL_NOT_TERMINAL + ")) -->$";

    public static final String CONDITION_HEAD = "^" + EVERGREEN + "(\\w+)" + CORN + "$";
    public static final String CONDITION_SEPARATOR = "^" + SQUIRT + "$";
    public static final String CONDITION_END = "^" + BANANA + "$";

    public static final String LOOP_HEAD = "^" + EXPLOSION + "(\\w+)" + HEART_BIG + "$";
    public static final String LOOP_END = "^" + GRAND_PA + "$";

    public static final String PUSH = "^" + LEMON + "(" + validVariableNamePattern() + "|(" + FUNCTION_CALL_NOT_TERMINAL + ")|(" + CALCULATION + "))" + SANTA + "$";
    public static final String POP = "^" + PINEAPPLE + validVariableNamePattern() + MONKEY_FACE + "$";

    public static final String BW_STRING = "^" + POODLE + "[^:;]*" + POOP + "$";

    public static String[] validVariableNameEmojis() {
        return new String[]{
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
                TWO_BEERS
        };
    }

    public static String validVariableNamePattern() {
        String pattern = "[";
        for (String string : validVariableNameEmojis()) {
            pattern += string;
        }
        pattern += "]+";
        return pattern;
    }
}
