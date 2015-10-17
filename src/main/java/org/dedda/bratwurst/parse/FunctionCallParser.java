package org.dedda.bratwurst.parse;

import org.dedda.bratwurst.lang.BWVariable;
import org.dedda.bratwurst.lang.FunctionCall;

import java.util.LinkedList;
import java.util.List;

import static org.dedda.bratwurst.parse.Patterns.FUNCTION_CALL_BEGIN_OBJECT;

/**
 * Created by dedda on 10/17/15.
 *
 * @author dedda
 */
public class FunctionCallParser {

    public FunctionCall parse(String line) {
        String objectName = null;
        String functionName;
        FunctionCall functionCall;
        List<BWVariable> arguments = new LinkedList<>();
        line = line.trim();
        if (!line.startsWith("{")) {
            objectName = line.split("\\{", 2)[0];
        }
        functionName = line.split("\\{", 2)[1].split("\\}", 2)[0];
        if (line.contains("@")) {
            arguments = parseArguments(line);
        }
        BWVariable[] argumentsArray = new BWVariable[arguments.size()];
        arguments.toArray(argumentsArray);
        if (objectName == null) {
            functionCall = new FunctionCall(functionName, argumentsArray);
        } else {
            functionCall = new FunctionCall(objectName, functionName, argumentsArray);
        }
        return functionCall;
    }

    private List<BWVariable> parseArguments(String line) {
        List<BWVariable> arguments = new LinkedList<>();
        line = line.split("@")[1];
        String[] split = line.split("&");
        for (String argumentString : split) {
            arguments.add(parseArgument(argumentString));
        }
        return arguments;
    }

    private BWVariable parseArgument(String data) {
        data = data.trim();
        BWVariable argument;
        String split[] = data.split(" ");
        argument = new BWVariable(split[0], new ExpressionParser().parse(split[2]));
        return argument;
    }

}
