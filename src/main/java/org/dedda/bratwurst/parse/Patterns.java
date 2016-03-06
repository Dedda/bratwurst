package org.dedda.bratwurst.parse;

/**
 * Created by dedda on 9/28/15.
 *
 * @author dedda
 */
public class Patterns {

    public static final String COMMENT = "^<\\(%.*";

    public static final String BEGIN = "^==>$";
    public static final String END = "^<==$";

    public static final String CLASS_BEGIN = "^#\\[$";
    public static final String CLASS_END = "^\\]$";

    public static final String FUNCTION_BEGIN = "^~\\{$";
    public static final String FUNCTION_END = "^\\}$";

    public static final String FUNCTION_PARAM_FIRST = "@ (\\w+) <-- (\\w+)";
    public static final String FUNCTION_PARAM_OTHERS = "& (\\w+) <-- (\\w+)";
    public static final String FUNCTION_CALL_BASE = "(\\w*)\\{(\\w+)\\}";
    public static final String FUNCTION_CALL_NOT_TERMINAL = FUNCTION_CALL_BASE + "( " + FUNCTION_PARAM_FIRST + ")?( " + FUNCTION_PARAM_OTHERS + ")*";
    public static final String FUNCTION_CALL = FUNCTION_CALL_NOT_TERMINAL + "$";

    public static final String CALCULATION = "((\\-?\\d+)|(\\w+)|(" + FUNCTION_CALL_NOT_TERMINAL + ")) [\\+\\-\\*\\/] ((\\-?\\d+)|\\w+|(" + FUNCTION_CALL_NOT_TERMINAL + "))";

    public static final String LENGTH_GET = "^\\)\\)\\w+\\)\\)$";

    public static final String TYPE_CHECK = "^\\w+ -\\?> \\w+$";
    public static final String CLASS_INSTANTIATION = "\\[(\\w+)\\]$";
    public static final String VARIABLE_DECLARATION = "^\\((\\w+)\\) <-- .*$";

    public static final String NAMING = "^\\(CALL_ME_MAYBE\\) <-- \\w+$";

    public static final String INCLUDE = "^%(\\w+[\\w\\.]+)%$";
    public static final String PRINT_VAR = ">[^\\|]*<";
    public static final String PRINT_INT = "\\|(\\w+)\\|";

    public static final String PRINT = "^(" + PRINT_VAR + "|" + PRINT_INT + ")$";

    public static final String RETURN = "^(\\w+|(" + FUNCTION_CALL_NOT_TERMINAL + ")) -->$";
    public static final String CONDITION_HEAD = "^\\?\\((\\w+\\))>>$";
    public static final String CONDITION_SEPARATOR = "^<<$";

    public static final String CONDITION_END = "^\\|$";
    public static final String LOOP_HEAD = "^/\\((\\w+)\\)$";

    public static final String LOOP_END = "^\\\\$";

    public static final String PUSH = "^>(\\w+|(" + FUNCTION_CALL_NOT_TERMINAL + ")|(" + CALCULATION + "))>$";
    public static final String POP = "^<\\w+<$";

    public static final String COMPARE = "^\\w+ = \\w+$";
    public static final String COMPARE_INT = "^\\w+ <=> \\w+$";

    public static final String BW_STRING = "^:[^:;]*;$";
    public static final String BW_STRING_CONCAT = "^\\w+( <-< \\w+)+$";
    public static final String BW_STRING_GET_CHAR = "^\\[\\w+\\}\\w+\\]$";

    public static final String READ_LINE = "^<__$";

    public static final String GUI_COMMAND = "^`\\w+,[\\w\\-]+(:\\w+,[\\w\\-]+)*`$";
    public static final String SYSTEM_CALL = "^>_ .*";

    public static final String CHAR_TO_INT = "^#__ \\w+$";
    public static final String INT_TO_CHAR = "^__# \\w+$";

    public static final String FILE_EXISTS = "\\?\\w+\\?$";
    public static final String FILE_CREATE = "^\\+\\w+\\+$";
    public static final String FILE_REMOVE = "^\\-\\w+\\-$";

    public static final String FILE_IMPORT = "^>\\|\\w+\\|<$";
    public static final String FILE_EXPORT = "^<\\|\\w+ > \\w+\\|>$";

    public static final String ASSERT_TRUE = "^\\{\\[(\\w+)\\]\\}$";
    public static final String ASSERT_FALSE = "^\\{\\[!(\\w+)\\]\\}$";

    public static final String ASSERT_EQUALS = "^\\{\\[(\\w+) == (\\w+)\\]\\}$";
    public static final String ASSERT_NOT_EQUALS = "^\\{\\[(\\w+) != (\\w+)\\]\\}$";
}
