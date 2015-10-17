package org.dedda.bratwurst.parse;

import org.dedda.bratwurst.lang.BWExpression;

import static org.dedda.bratwurst.parse.Patterns.CALCULATION;
import static org.dedda.bratwurst.parse.Patterns.CLASS_INSTANTIATION;
import static org.dedda.bratwurst.parse.Patterns.FUNCTION_CALL_NOT_TERMINAL;

/**
 * Created by dedda on 10/17/15.
 *
 * @author dedda
 */
public class ExpressionParser {

    public BWExpression parse(String data) {
        data = data.trim();
        if (data.matches("-?\\d*")) {
            return new IntegerParser().parse(data);
        } else if (data.matches("\\w+")) {
            return new ReadVariableParser().parse(data);
        } else if (data.matches(CALCULATION)) {
            return new CalculationParser().parse(data);
        } else if (data.matches(FUNCTION_CALL_NOT_TERMINAL)) {
            return new FunctionCallParser().parse(data);
        } else if (data.matches(CLASS_INSTANTIATION)) {
            return new ObjectCreationParser().parse(data);
        }
        return null;
    }

}
