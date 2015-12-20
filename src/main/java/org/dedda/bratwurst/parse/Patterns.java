package org.dedda.bratwurst.parse;

import static org.dedda.bratwurst.parse.Emoji.*;

/**
 * Created by dedda on 9/28/15.
 *
 * @author dedda
 */
public class Patterns {

    public static final String NUMBER = "(\\-?\\d+)";

    public static final String[] VALID_VARIABLE_NAME_EMOJIS = new String[]{
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

    public static final String[] VALID_CLASS_NAME_EMOJIS = new String[]{
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
            NERD
    };

    public static final String[] VALID_FUNCTION_NAME_EMOJIS = new String[]{
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
            DONUT
    };

    public static final String[] VALID_STRING_EMOJIS = new String[]{
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
            TOILET
    };

    public static final String VARIABLE_NAME = validPatternFromEmojis(VALID_VARIABLE_NAME_EMOJIS);
    public static final String CLASS_NAME = validPatternFromEmojis(VALID_CLASS_NAME_EMOJIS);
    public static final String FUNCTION_NAME = validPatternFromEmojis(VALID_FUNCTION_NAME_EMOJIS);
    public static final String STRING_VALUE = validPatternFromEmojis(VALID_STRING_EMOJIS);

    public static final String BEGIN = "^" + ALIEN + "$";
    public static final String END = "^" + ALL_OK + "$";

    public static final String CLASS_BEGIN = "^" + GHOST + "$";
    public static final String CLASS_END = "^" + ANGEL_FACE + "$";

    public static final String FUNCTION_BEGIN = "^" + BOMB + "$";
    public static final String FUNCTION_END = "^" + FLEX + "$";

    public static final String FUNCTION_PARAM_FIRST = "@ " + VARIABLE_NAME + " <-- (" + VARIABLE_NAME + "|" + NUMBER + ")";
    public static final String FUNCTION_PARAM_OTHERS = "& " + VARIABLE_NAME + " <-- (" + VARIABLE_NAME + "|" + NUMBER + ")";
    public static final String FUNCTION_CALL_NOT_TERMINAL = VARIABLE_NAME + "\\{(" + FUNCTION_NAME + ")\\}( " + FUNCTION_PARAM_FIRST + ")?( " + FUNCTION_PARAM_OTHERS + ")*";
    public static final String FUNCTION_CALL = FUNCTION_CALL_NOT_TERMINAL + "$";

    public static final String CALCULATION_PARAMETER = "(" + NUMBER + "|" + VARIABLE_NAME + "|(" + FUNCTION_CALL_NOT_TERMINAL + "))";

    public static final String CALCULATION = CALCULATION_PARAMETER + " [\\+\\-\\*\\/] " + CALCULATION_PARAMETER;

    public static final String TYPE_CHECK = "^((" + VARIABLE_NAME + ")|(" + NUMBER + "))" + CACTUS + CLASS_NAME + "$";
    public static final String CLASS_INSTANTIATION = "\\[(" + CLASS_NAME + ")\\]$";
    public static final String VARIABLE_DECLARATION = "^\\(" + VARIABLE_NAME + "\\) <-- .*$";

    public static final String CLASS_NAMING = "^" + DOCTOR_MASK + CLASS_NAME + DIAMOND + "$";
    public static final String FUNCTION_NAMING = "^" + DOCTOR_MASK + FUNCTION_NAME + DIAMOND + "$";

    public static final String INCLUDE = "^%(\\w+[\\w\\.]+)%$";
    public static final String PRINT_VAR = SNAKE + "((" + VARIABLE_NAME + ")|.|" + NUMBER + ")" + TURBAN;
    public static final String PRINT_INT = X_X + "(" + NUMBER + "|(" + VARIABLE_NAME + ")|.)" + PIG;

    public static final String PRINT = "^(" + PRINT_VAR + ")|(" + PRINT_INT + ")$";

    public static final String RETURN = "^(" + VARIABLE_NAME + "|(" + FUNCTION_CALL_NOT_TERMINAL + ")) -->$";

    public static final String CONDITION_HEAD = "^" + EVERGREEN + "(" + VARIABLE_NAME + ")" + CORN + "$";
    public static final String CONDITION_SEPARATOR = "^" + SQUIRT + "$";
    public static final String CONDITION_END = "^" + BANANA + "$";

    public static final String LOOP_HEAD = "^" + EXPLOSION + "(" + VARIABLE_NAME + ")" + HEART_BIG + "$";
    public static final String LOOP_END = "^" + GRAND_PA + "$";

    public static final String PUSH = "^" + LEMON + "(" + VARIABLE_NAME + "|(" + FUNCTION_CALL_NOT_TERMINAL + ")|(" + CALCULATION + ")|" + NUMBER + ")" + SANTA + "$";
    public static final String POP = "^" + PINEAPPLE + VARIABLE_NAME + MONKEY_FACE + "$";

    public static final String BW_STRING = "^" + POODLE + STRING_VALUE + POOP + "$";

    public static String validPatternFromEmojis(String[] emojis) {
        String pattern = "[";
        for (String string : emojis) {
            pattern += string;
        }
        pattern += "]+";
        return pattern;
    }
}
