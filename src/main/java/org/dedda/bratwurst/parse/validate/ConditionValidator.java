package org.dedda.bratwurst.parse.validate;

/**
 * Created by dedda on 9/27/15.
 *
 * @author dedda
 */
public class ConditionValidator extends BaseValidator {

    public boolean validateHead(final String line) {
        String trimmed = line.trim();
        if (!(trimmed.startsWith("?(") && trimmed.endsWith(")>>"))) {
            error("condition syntax", "keywords '?(' or ')>>' not found");
            return false;
        }
        if (!isEvaluable(line.substring(2, line.length()-3))) {
            error("condition syntax", "cannot evaluate head contents");
            return false;
        }
        return true;
    }

}
