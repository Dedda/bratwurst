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

    public static final String FUNCTION_PARAM_FIRST = "@ \\w+ <-- \\w+";
    public static final String FUNCTION_PARAM_OTHERS = "& \\w+ <-- \\w+";

    public static final String FUNCTION_CALL = "\\w+\\{\\w+\\}( " + FUNCTION_PARAM_FIRST + ")?( " + FUNCTION_PARAM_OTHERS + ")*$";
    public static final String CLASS_INSTANTIATION = "\\[\\w+\\]$";
    public static final String VARIABLE_DECLARATION = "^\\(\\w+\\) <-- (\\w+|" + FUNCTION_CALL + "|" + CLASS_INSTANTIATION + ")$";

    public static final String INCLUDE = "^%\\w+[\\w\\.]+%$";

    public static final String PRINT = "^>[^>].*[^<]<$";

    public static final String CONDITION_HEAD = "^\\?\\(\\w+\\)>>$";
    public static final String CONDITION_SEPARATOR = "^<<$";
    public static final String CONDITION_END = "^\\|$";

    public static final String LOOP_HEAD = "^/\\(\\w+\\)$";
    public static final String LOOP_END = "^\\\\$";

}
