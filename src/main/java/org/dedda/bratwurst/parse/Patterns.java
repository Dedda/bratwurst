package org.dedda.bratwurst.parse;

/**
 * Created by dedda on 9/28/15.
 *
 * @author dedda
 */
public class Patterns {

    public static final String BEGIN = "^==>$";
    public static final String END = "^<==$";

    public static final String CLASS_BEGIN = "^#\\[$";
    public static final String CLASS_END = "^\\]$";

    public static final String FUNCTION_BEGIN = "^~\\{$";
    public static final String FUNCTION_END = "^\\}$";
    public static final String FUNCTION_PARAM_FIRST = "@ (\\w+) <-- (\\w+)";

    public static final String FUNCTION_PARAM_OTHERS = "& (\\w+) <-- (\\w+)";
    public static final String FUNCTION_CALL_NOT_TERMINAL = "(\\w*)\\{(\\w+)\\}( " + FUNCTION_PARAM_FIRST + ")?( " + FUNCTION_PARAM_OTHERS + ")*";
    public static final String FUNCTION_CALL = FUNCTION_CALL_NOT_TERMINAL + "$";
    public static final String FUNCTION_CALL_BEGIN_DEFAULT = "\\{\\w+\\}";
    public static final String FUNCTION_CALL_BEGIN_OBJECT = "(\\w+)" + FUNCTION_CALL_BEGIN_DEFAULT;

    public static final String CLASS_INSTANTIATION = "\\[(\\w+)\\]$";
    public static final String VARIABLE_DECLARATION = "^\\((\\w+)\\) <-- ((\\-?\\d+)|(\\w+)|(" + FUNCTION_CALL + ")|(" + CLASS_INSTANTIATION + "))$";
    public static final String NAMING = "^\\(CALL_ME_MAYBE\\) <-- \\w+$";

    public static final String INCLUDE = "^%(\\w+[\\w\\.]+)%$";

    public static final String PRINT_VAR = ">(.*)<";
    public static final String PRINT_INT = "\\|(\\w+)\\|";
    public static final String PRINT = "^(" + PRINT_VAR + "|" + PRINT_INT + ")$";

    public static final String CALCULATION = "((\\-?\\d+)|(\\w+)|(" + FUNCTION_CALL_NOT_TERMINAL + ")) [\\+\\-\\*\\/] ((\\-?\\d+)|\\w+|(" + FUNCTION_CALL_NOT_TERMINAL + "))";
    public static final String RETURN = "^(\\w+|(" + FUNCTION_CALL_NOT_TERMINAL + ")) -->$";

    public static final String CONDITION_HEAD = "^\\?\\((\\w+\\))>>$";
    public static final String CONDITION_SEPARATOR = "^<<$";
    public static final String CONDITION_END = "^\\|$";

    public static final String LOOP_HEAD = "^/\\((\\w+)\\)$";
    public static final String LOOP_END = "^\\\\$";

}
