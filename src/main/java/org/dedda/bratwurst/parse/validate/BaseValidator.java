package org.dedda.bratwurst.parse.validate;

/**
 * Created by dedda on 9/27/15.
 *
 * @author dedda
 */
public class BaseValidator {

    protected ValidationErrorContainer errorContainer = new ValidationErrorContainer();

    public boolean isEvaluable(String expression) {
        return true;
    }

    public ValidationErrorContainer getErrorContainer() {
        return errorContainer;
    }

    public void setErrorContainer(ValidationErrorContainer errorContainer) {
        this.errorContainer = errorContainer;
    }

    public boolean isCorrectClassInstantiation(final String instanciation) {
        return true;
    }

    public boolean isCorrectFunctionCall(final String call) {
        String split[] = call.split(" ");
        if (!split[0].matches("(\\w+)(\\{)(\\w+)(\\})")) {
            errorContainer.addError(new ValidationError("function call syntax", "not a function call!"));
            return false;
        }
        if (split.length == 1) {
            return true;
        }
        if (split.length % 4 != 1) {
            errorContainer.addError(new ValidationError("function call syntax", "wrong number of parts"));
            return false;
        }
        if (!split[1].equals("@")) {
            errorContainer.addError(new ValidationError("function call syntax", "arguments don't start with '@'"));
            return false;
        }
        for (int i = 2; i < split.length; i++) {
            int part = i % 4;
            String word = split[i];
            switch (part) {
                case 3: {
                    if (!word.equals("<--")) {
                        errorContainer.addError(new ValidationError("function call syntax", "expected '<--'"));
                        return false;
                    }
                    break;
                }
                case 0: {
                    if (!isEvaluable(word)) {
                        errorContainer.addError(new ValidationError("function call syntax", "not an evaluable expression"));
                        return false;
                    }
                    break;
                }
                case 1: {
                    if (!word.equals("&")) {
                        errorContainer.addError(new ValidationError("function call syntax", "arguments not connected by '&' (" + split[i] + ")"));
                        return false;
                    }
                    break;
                }
                case 2: {
                    if (!word.matches("(\\w+)")) {
                        errorContainer.addError(new ValidationError("function call syntax", "argument name not only word characters"));
                        return false;
                    }
                    break;
                }
            }
        }
        return true;
    }

    protected void error(final String type, final String message) {
        this.errorContainer.addError(new ValidationError(type, message));
    }
}
