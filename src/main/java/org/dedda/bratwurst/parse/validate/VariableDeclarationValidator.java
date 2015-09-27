package org.dedda.bratwurst.parse.validate;

/**
 * Created by dedda on 9/27/15.
 *
 * @author dedda
 */
public class VariableDeclarationValidator extends BaseValidator {

    public boolean validate(final String line) {
        String trimmed = line.trim();
        String split[] = trimmed.split(" ", 3);
        if (!split[0].matches("(\\w+)")) {
            return false;
        }
        if (!split[1].equals("<--")) {
            return false;
        }
        if (split[2].matches("\\[(\\w+)\\]")) {
            return isCorrectClassInstantiation(split[2]);
        } else if (split[2].matches("(\\w+)\\{(\\w+)\\}(.*)")) {
            return isCorrectFunctionCall(split[2]);
        }
        return true;
    }
}
