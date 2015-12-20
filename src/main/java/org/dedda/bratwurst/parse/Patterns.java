package org.dedda.bratwurst.parse;

import static org.dedda.bratwurst.parse.Emoji.*;

/**
 * Created by dedda on 9/28/15.
 *
 * @author dedda
 */
public class Patterns {

    public static final String STRICT_START = "^";
    public static final String STRICT_END = "$";
    public static final String GROUP_OPEN = "(";
    public static final String GROUP_CLOSE = ")";
    public static final String CHAR_SELECTION_OPEN = "[";
    public static final String CHAR_SELECTION_CLOSE = "]";
    public static final String OR = "|";
    public static final String OPTIONAL = "?";
    public static final String AT_LEAST_ONE = "+";
    public static final String ANY_AMOUNT = "*";
    public static final String ANY_CHAR = ".";
    public static final String SPACE = " ";
    public static final String WORD_CHARACTER = "\\w";
    public static final String DOT = "\\.";

    public static final String NUMBER = group("\\-?\\d+");

    public static final String VARIABLE_DECLARATION_OPEN = "\\(";
    public static final String VARIABLE_DECLARATION_CLOSE = "\\)";
    public static final String CLASS_INSTANTIATION_OPEN = "\\[";
    public static final String CLASS_INSTANTIATION_CLOSE = "\\]";
    public static final String FUNCTION_CALL_OPEN = "\\{";
    public static final String FUNCTION_CALL_CLOSE = "\\}";
    public static final String ASSIGNMENT_OPERATOR = " <-- ";
    public static final String FUNCTION_PARAM_FIRST_PRE = "@ ";
    public static final String FUNCTION_PARAM_OTHERS_PRE = "& ";
    public static final String CALCULATION_OPERATOR = SPACE + charSelection("\\+", "\\-", "\\*", "\\/") + SPACE;
    public static final String RETURN_OPERATOR = " -->";
    public static final String INCLUDE_IDENTIFIER = "%";

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

    public static final String VARIABLE_NAME = group(validPatternFromEmojis(VALID_VARIABLE_NAME_EMOJIS));
    public static final String CLASS_NAME = group(validPatternFromEmojis(VALID_CLASS_NAME_EMOJIS));
    public static final String FUNCTION_NAME = group(validPatternFromEmojis(VALID_FUNCTION_NAME_EMOJIS));
    public static final String STRING_VALUE = group(validPatternFromEmojis(VALID_STRING_EMOJIS));

    public static final String BEGIN = strict(ALIEN);
    public static final String END = strict(ALL_OK);

    public static final String CLASS_BEGIN = strict(GHOST);
    public static final String CLASS_END = strict(ANGEL_FACE);

    public static final String FUNCTION_BEGIN = strict(BOMB);
    public static final String FUNCTION_END = strict(FLEX);

    public static final String BW_STRING = strict(POODLE + STRING_VALUE + POOP);

    public static final String VALID_FUNCTION_PARAM_VALUE = group(or(VARIABLE_NAME, NUMBER, BW_STRING));
    public static final String FUNCTION_PARAM_ASSIGNMENT = VARIABLE_NAME + ASSIGNMENT_OPERATOR + VALID_FUNCTION_PARAM_VALUE;
    public static final String FUNCTION_PARAM_FIRST = FUNCTION_PARAM_FIRST_PRE + FUNCTION_PARAM_ASSIGNMENT;
    public static final String FUNCTION_PARAM_OTHERS = FUNCTION_PARAM_OTHERS_PRE + FUNCTION_PARAM_ASSIGNMENT;
    public static final String FUNCTION_CALL_BASIC = FUNCTION_CALL_OPEN + FUNCTION_NAME + FUNCTION_CALL_CLOSE;
    public static final String FUNCTION_CALL_NOT_TERMINAL = optional(VARIABLE_NAME) + FUNCTION_CALL_BASIC + optional(group(SPACE + FUNCTION_PARAM_FIRST)) + anyAmount(group(SPACE + FUNCTION_PARAM_OTHERS));
    public static final String FUNCTION_CALL = FUNCTION_CALL_NOT_TERMINAL + STRICT_END;

    public static final String CALCULATION_PARAMETER = group(or(NUMBER, VARIABLE_NAME, group(FUNCTION_CALL_NOT_TERMINAL)));
    public static final String CALCULATION = CALCULATION_PARAMETER + CALCULATION_OPERATOR + CALCULATION_PARAMETER;

    public static final String TYPE_CHECK = strict(group(or(VARIABLE_NAME, group(NUMBER))) + CACTUS + CLASS_NAME);
    public static final String CLASS_INSTANTIATION = CLASS_INSTANTIATION_OPEN + CLASS_NAME + CLASS_INSTANTIATION_CLOSE;
    public static final String VARIABLE_DECLARATION = strict(VARIABLE_DECLARATION_OPEN + VARIABLE_NAME + VARIABLE_DECLARATION_CLOSE + ASSIGNMENT_OPERATOR + anyAmount(ANY_CHAR));

    public static final String CLASS_NAMING = strict(DOCTOR_MASK + CLASS_NAME + DIAMOND);
    public static final String FUNCTION_NAMING = strict(DOCTOR_MASK + FUNCTION_NAME + DIAMOND);

    public static final String FILE_NAME = group(atLeastOne(WORD_CHARACTER) + atLeastOne(charSelection(WORD_CHARACTER, DOT)));
    public static final String INCLUDE = strict(INCLUDE_IDENTIFIER + FILE_NAME + INCLUDE_IDENTIFIER);
    public static final String PRINT_VAR = SNAKE + or(VARIABLE_NAME, ANY_CHAR, NUMBER) + TURBAN;
    public static final String PRINT_INT = X_X + or(NUMBER, VARIABLE_NAME, ANY_CHAR) + PIG;

    public static final String PRINT = strict(or(group(PRINT_VAR), group(PRINT_INT)));

    public static final String VALID_RETURN_VALUE = or(VARIABLE_NAME, group(FUNCTION_CALL_NOT_TERMINAL));
    public static final String RETURN = strict(VALID_RETURN_VALUE + RETURN_OPERATOR);

    public static final String CONDITION_HEAD = strict(EVERGREEN + VARIABLE_NAME + CORN);
    public static final String CONDITION_SEPARATOR = strict(SQUIRT);
    public static final String CONDITION_END = strict(BANANA);

    public static final String LOOP_HEAD = strict(EXPLOSION + VARIABLE_NAME + HEART_BIG);
    public static final String LOOP_END = strict(GRAND_PA);

    public static final String PUSH = strict(LEMON + or(VARIABLE_NAME, group(FUNCTION_CALL_NOT_TERMINAL), group(CALCULATION), NUMBER) + SANTA);
    public static final String POP = strict(PINEAPPLE + VARIABLE_NAME + MONKEY_FACE);

    public static String validPatternFromEmojis(String[] emojis) {
        String pattern = charSelection(emojis);
        return atLeastOne(pattern);
    }

    public static String strict(String pattern) {
        return STRICT_START + pattern + STRICT_END;
    }

    public static String group(String pattern) {
        return GROUP_OPEN + pattern + GROUP_CLOSE;
    }

    public static String optional(String pattern) {
        return group(pattern) + OPTIONAL;
    }

    public static String atLeastOne(String pattern) {
        return group(pattern) + AT_LEAST_ONE;
    }

    public static String anyAmount(String pattern) {
        return group(pattern) + ANY_AMOUNT;
    }

    public static String or(String... patterns) {
        if (patterns.length == 0) {
            return "";
        } else if (patterns.length == 1) {
            return group(patterns[0]);
        }
        String pattern = patterns[0];
        for (int i = 1; i < patterns.length; i++) {
            pattern += OR + patterns[i];
        }
        return group(pattern);
    }

    public static String charSelection(String... patterns) {
        if (patterns.length == 0) {
            return "";
        } else if (patterns.length == 1) {
            return group(patterns[0]);
        }
        String pattern = patterns[0];
        for (int i = 1; i < patterns.length; i++) {
            pattern += patterns[i];
        }
        return CHAR_SELECTION_OPEN + pattern + CHAR_SELECTION_CLOSE;
    }

}
