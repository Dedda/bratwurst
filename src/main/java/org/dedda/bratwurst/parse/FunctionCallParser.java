package org.dedda.bratwurst.parse;

import org.dedda.bratwurst.lang.BWVariable;
import org.dedda.bratwurst.lang.FunctionCall;

import java.util.LinkedList;
import java.util.List;

import static org.dedda.bratwurst.parse.Patterns.*;

/**
 * Created by dedda on 10/17/15.
 *
 * @author dedda
 */
public class FunctionCallParser extends ExpressionParser {

    public FunctionCall parse(String line, int lineNumber) {
        String objectName = null;
        String functionName;
        FunctionCall functionCall;
        List<BWVariable> arguments = new LinkedList<>();
        line = line.trim();
        if (!line.startsWith(FUNCTION_CALL_OPEN)) {
            objectName = line.split(FUNCTION_CALL_OPEN, 2)[0];
        }
        functionName = line.split(FUNCTION_CALL_OPEN, 2)[1].split(FUNCTION_CALL_CLOSE, 2)[0];
        if (line.contains(FUNCTION_PARAM_FIRST_PRE)) {
            arguments = parseArguments(line, lineNumber);
        }
        BWVariable[] argumentsArray = new BWVariable[arguments.size()];
        arguments.toArray(argumentsArray);
        if (objectName == null) {
            functionCall = new FunctionCall(lineNumber, functionName, argumentsArray);
        } else {
            functionCall = new FunctionCall(lineNumber, objectName, functionName, argumentsArray);
        }
        return functionCall;
    }

    private List<BWVariable> parseArguments(String line, int lineNumber) {
        List<BWVariable> arguments = new LinkedList<>();
        line = line.split(FUNCTION_PARAM_FIRST_PRE)[1].trim();
        String[] split = line.split(FUNCTION_PARAM_OTHERS_PRE);
        for (String argumentString : split) {
            arguments.add(parseArgument(argumentString, lineNumber));
        }
        return arguments;
    }

    private BWVariable parseArgument(String data, int lineNumber) {
        data = data.trim();
        BWVariable argument;
        String split[] = data.split(ASSIGNMENT_OPERATOR);
        argument = new BWVariable(split[0].trim(), new ExpressionParser().parse(split[1].trim(), lineNumber));
        return argument;
    }

}
