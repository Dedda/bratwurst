package org.dedda.bratwurst.parse.validate;

import static org.dedda.bratwurst.parse.Patterns.VARIABLE_DECLARATION;

/**
 * Created by dedda on 9/27/15.
 *
 * @author dedda
 */
public class VariableDeclarationValidator extends BaseValidator {

    public boolean validate(final String line) {
        String trimmed = line.trim();
        return trimmed.matches(VARIABLE_DECLARATION);
    }
}
