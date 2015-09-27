package org.dedda.bratwurst.parse.validate;

/**
 * Created by dedda on 9/27/15.
 *
 * @author dedda
 */
public class ValidationError {

    public final String type;
    public final String message;

    public ValidationError(String type, String message) {
        this.type = type;
        this.message = message;
    }
}
