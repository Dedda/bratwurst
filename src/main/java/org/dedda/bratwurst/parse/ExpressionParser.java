package org.dedda.bratwurst.parse;

import org.dedda.bratwurst.lang.BWExpression;

import static org.dedda.bratwurst.parse.Patterns.BW_STRING;
import static org.dedda.bratwurst.parse.Patterns.CALCULATION;
import static org.dedda.bratwurst.parse.Patterns.CLASS_INSTANTIATION;
import static org.dedda.bratwurst.parse.Patterns.FUNCTION_CALL_NOT_TERMINAL;
import static org.dedda.bratwurst.parse.Patterns.TYPE_CHECK;
import static org.dedda.bratwurst.parse.Patterns.VARIABLE_NAME;

/**
 * Created by dedda on 10/17/15.
 *
 * @author dedda
 */
public class ExpressionParser {

    public BWExpression parse(String data, int lineNumber) {
        data = data.replace((char) 10, ' ');
        data = data.replace((char) 13, ' ');
        data = data.trim();
        ExpressionParser parser = forExpression(data);
        if (parser != null) {
            return parser.parse(data, lineNumber);
        }
        return null;
    }

    public static ExpressionParser forExpression(String expression) {
        if (expression.matches("^-?\\d*$")) {
            return new IntegerParser();
        } else if (expression.matches(VARIABLE_NAME)) {
            return new ReadVariableParser();
        } else if (expression.matches(TYPE_CHECK)) {
            return new InstanceofParser();
        } else if (expression.matches(CALCULATION)) {
            return new CalculationParser();
        } else if (expression.matches(FUNCTION_CALL_NOT_TERMINAL)) {
            return new FunctionCallParser();
        } else if (expression.matches(CLASS_INSTANTIATION)) {
            return new ObjectCreationParser();
        } else if (expression.matches(BW_STRING)) {
            return new StringParser();
        }
        return null;
    }

}
