package org.dedda.bratwurst.parse;

import org.dedda.bratwurst.lang.BWExpression;
import org.dedda.bratwurst.lang.BWInteger;
import org.dedda.bratwurst.lang.VariableDeclaration;

import static org.dedda.bratwurst.parse.Emoji.BOY;
import static org.dedda.bratwurst.parse.Emoji.BREAD;
import static org.dedda.bratwurst.parse.Emoji.CANDY;
import static org.dedda.bratwurst.parse.Emoji.CHERRIES;
import static org.dedda.bratwurst.parse.Emoji.CLOVER;
import static org.dedda.bratwurst.parse.Emoji.COOKIE;
import static org.dedda.bratwurst.parse.Emoji.FRIED_SHRIMP;
import static org.dedda.bratwurst.parse.Emoji.HOT_DOG;
import static org.dedda.bratwurst.parse.Emoji.METAL;
import static org.dedda.bratwurst.parse.Emoji.OCTOPUS;
import static org.dedda.bratwurst.parse.Emoji.PEAR;
import static org.dedda.bratwurst.parse.Emoji.ROSE;
import static org.dedda.bratwurst.parse.Emoji.SKULL_BONES;
import static org.dedda.bratwurst.parse.Emoji.TIGER;
import static org.dedda.bratwurst.parse.Emoji.TWO_BEERS;
import static org.dedda.bratwurst.parse.Emoji.WINE;
import static org.dedda.bratwurst.parse.Patterns.validVariableNameEmojis;

/**
 * Created by dedda on 9/25/15.
 *
 * @author dedda
 */
public class VariableDeclarationParser extends InstructionParser {

    public VariableDeclaration parseDeclaration(final String line, int lineNumber) {
        VariableDeclaration declaration;
        String[] split = line.split(" ", 3);
        String variableName = split[0].substring(1, split[0].length()-1);
        if (!new StringValidator().isValid(variableName, validVariableNameEmojis())) {
            throw new RuntimeException("\"" + variableName + "\" is not a valid variable name!");
        }
        String expressionString = split[2];
        BWExpression expression = new ExpressionParser().parse(expressionString, lineNumber);
        declaration = new VariableDeclaration(lineNumber, variableName, expression);
        return declaration;
    }
}
