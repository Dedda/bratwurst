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

    public static final String CALCULATION = "((\\-?\\d+)|(\\w+)|(" + FUNCTION_CALL_NOT_TERMINAL + ")) [\\+\\-\\*\\/] ((\\-?\\d+)|\\w+|(" + FUNCTION_CALL_NOT_TERMINAL + "))";

    public static final String TYPE_CHECK = "^\\w+ " + CACTUS + " \\w+$";
    public static final String CLASS_INSTANTIATION = "\\[(\\w+)\\]$";
    public static final String VARIABLE_DECLARATION = "^\\((\\w+)\\) <-- .*$";

    public static final String NAMING = "^" + DOCTOR_MASK + "\\w+" + DIAMOND + "$";

    public static final String INCLUDE = "^%(\\w+[\\w\\.]+)%$";
    public static final String PRINT_VAR = SNAKE + "(.*)" + TURBAN;
    public static final String PRINT_INT = X_X + "(\\w+)" + PIG;

    public static final String PRINT = "^(" + PRINT_VAR + "|" + PRINT_INT + ")$";

    public static final String RETURN = "^(\\w+|(" + FUNCTION_CALL_NOT_TERMINAL + ")) -->$";

    public static final String CONDITION_HEAD = "^" + EVERGREEN + "(\\w+)" + CORN + "$";
    public static final String CONDITION_SEPARATOR = "^" + SQUIRT + "$";
    public static final String CONDITION_END = "^" + BANANA + "$";

    public static final String LOOP_HEAD = "^" + EXPLOSION + "(\\w+)" + HEART_BIG + "$";
    public static final String LOOP_END = "^" + GRAND_PA + "$";

    public static final String PUSH = "^>(\\w+|(" + FUNCTION_CALL_NOT_TERMINAL + ")|(" + CALCULATION + "))>$";
    public static final String POP = "^<\\w+<$";

    public static final String BW_STRING = "^" + POODLE + "[^:;]*" + POOP + "$";
}
