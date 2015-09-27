package org.dedda.bratwurst.parse.validate;

/**
 * Created by dedda on 9/25/15.
 *
 * @author dedda
 */
public class EntryPointValidator {

    public int validate(String sourceCode) {
        int n = 0;
        sourceCode = sourceCode.trim();
        if (!sourceCode.startsWith("==>")) {
            throw new RuntimeException("source code does not start with entry point!");
        }
        while (sourceCode.contains("==>")) {
            n++;
            sourceCode = sourceCode.substring(sourceCode.indexOf("==>") + 1);
        }
        return n;
    }

}
