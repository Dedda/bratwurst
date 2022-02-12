package org.dedda.bratwurst.parse;

import org.dedda.bratwurst.lang.BWExpression;

import java.util.HashMap;
import java.util.Optional;
import java.util.function.Supplier;

import static org.dedda.bratwurst.parse.Patterns.*;

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

    private static ExpressionParser forExpression(String expression) {
        final HashMap<String, Supplier<ExpressionParser>> mapping = new HashMap<>();
        mapping.put("^-?\\d*$", IntegerParser::new);
        mapping.put("^\\w+$", ReadVariableParser::new);
        mapping.put(TYPE_CHECK, InstanceofParser::new);
        mapping.put(CALCULATION, CalculationParser::new);
        mapping.put(FUNCTION_CALL_NOT_TERMINAL, FunctionCallParser::new);
        mapping.put(CLASS_INSTANTIATION, ObjectCreationParser::new);
        mapping.put(BW_STRING, StringParser::new);
        mapping.put(FILE_EXISTS, FileExistsParser::new);
        mapping.put(BW_STRING_CONCAT, StringConcatenationParser::new);
        mapping.put(BW_STRING_GET_CHAR, StringGetCharParser::new);
        mapping.put(LENGTH_GET, LengthGetParser::new);
        mapping.put(COMPARE, ComparisonParser::new);
        mapping.put(COMPARE_INT, IntegerComparisonParser::new);
        mapping.put(READ_LINE, ReadLineParser::new);
        mapping.put(CHAR_TO_INT, CharToIntParser::new);
        mapping.put(INT_TO_CHAR, IntToCharParser::new);
        final Optional<String> pattern = mapping.keySet().stream().filter(expression::matches).findFirst();
        return pattern.map(mapping::get).map(Supplier::get).orElse(null);
    }

}
