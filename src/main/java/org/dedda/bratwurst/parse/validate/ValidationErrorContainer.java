package org.dedda.bratwurst.parse.validate;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by dedda on 9/27/15.
 *
 * @author dedda
 */
public class ValidationErrorContainer {

    private List<ValidationError> errors;

    public ValidationErrorContainer() {
        errors = new LinkedList<>();
    }

    public void addError(final ValidationError error) {
        this.errors.add(error);
    }

    public void addErrors(final ValidationErrorContainer container) {
        List<ValidationError> errors = container.getErrors();
        for (ValidationError error : errors) {
            addError(error);
        }
    }

    public List<ValidationError> getErrors() {
        return this.errors;
    }

}
