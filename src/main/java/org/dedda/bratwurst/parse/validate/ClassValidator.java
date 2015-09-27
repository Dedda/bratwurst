package org.dedda.bratwurst.parse.validate;

/**
 * Created by dedda on 9/27/15.
 *
 * @author dedda
 */
public class ClassValidator extends BaseValidator {

    public boolean validate(final String lines[], final int startLine, final int endLine) {
        int brackets = 0;
        int squareBrackets;
        int curlyBrackets = 0;
        boolean isNamed = false;
        boolean inClass = false;
        boolean inFunction = false;
        if (!lines[startLine].trim().equals("#[")) {
            error("class syntax", "class declaration doesn't start with '#['");
            return false;
        }
        if (!lines[endLine].trim().equals("]")) {
            error("class syntax", "class declaration doesn't end with ']'");
            return false;
        }
        inClass = true;
        squareBrackets = 1;
        for (int i = startLine + 1; i <= endLine - 1; i++) {
            String trimmed = lines[i].trim();
            if (trimmed.equals("")) {
                continue;
            }
            if (trimmed.equals("]")) {
                squareBrackets--;
                if (squareBrackets == 0) {
                    inClass = false;
                    break;
                } else {
                    continue;
                }
            }
            if (!inClass) {
                break;
            }
            if (trimmed.matches("\\(CALL_ME_MAYBE\\) <-- (\\w+)")) {
                if (!inFunction) {
                    if (isNamed) {
                        error("class syntax", "class already named");
                        return false;
                    }
                    isNamed = true;
                    continue;
                }
            }
            if (trimmed.split(" ")[0].matches("(\\w+) <--")) {
                if (!new VariableDeclarationValidator().validate(trimmed)) {
                    error("class syntax", "invalid variable declaration");
                    return false;
                }
                continue;
            }
            error("class syntax", "unexpected text '" + trimmed + "'");
        }
        return true;
    }

}
