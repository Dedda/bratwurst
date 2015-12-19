package org.dedda.bratwurst.parse;

/**
 * Created by dedda on 12/19/15.
 *
 * @author dedda
 */
public class StringValidator {

    public boolean isValid(String value, String[] allowedCodes) {
        int counter = 0;
        int codeLength;
        while (counter < value.length()) {
            String code = String.valueOf(Character.toChars(value.codePointAt(counter)));
            codeLength = code.length();
            boolean validCode = false;
            for (String compareTo : allowedCodes) {
                if (code.equals(compareTo)) {
                    validCode = true;
                    break;
                }
            }
            if (!validCode) {
                return false;
            }
            counter += codeLength;
        }
        return true;
    }

}
