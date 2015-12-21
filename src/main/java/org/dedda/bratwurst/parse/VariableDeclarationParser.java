package org.dedda.bratwurst.parse;

import org.dedda.bratwurst.lang.BWExpression;
import org.dedda.bratwurst.lang.VariableDeclaration;

import static org.dedda.bratwurst.parse.Patterns.*;
import static org.dedda.bratwurst.parse.Patterns.VARIABLE_DECLARATION_CLOSE;
import static org.dedda.bratwurst.parse.Patterns.VARIABLE_NAME;

/**
 * Created by dedda on 9/25/15.
 *
 * @author dedda
 */
public class VariableDeclarationParser extends InstructionParser {

    public VariableDeclaration parseDeclaration(final String line, int lineNumber) {
        VariableDeclaration declaration;
        String[] split = line.split(" ", 3);
        String variableName = split[0].substring(
                VARIABLE_DECLARATION_OPEN.length(),
                split[0].length()-VARIABLE_DECLARATION_CLOSE.length());
        if (!variableName.matches(VARIABLE_NAME)) {
            throw new RuntimeException("\"" + variableName + "\" is not a valid variable name!");
        }
        String expressionString = split[2];
        BWExpression expression = new ExpressionParser().parse(expressionString, lineNumber);
        declaration = new VariableDeclaration(lineNumber, variableName, expression);
        return declaration;
    }
}
