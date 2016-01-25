package org.dedda.bratwurst.parse;

import org.dedda.bratwurst.lang.io.file.FileExists;

/**
 * Created by dedda on 1/25/16.
 *
 * @author dedda
 */
public class FileExistsParser extends ExpressionParser {

    @Override
    public FileExists parse(String data, int linenumber) {
        String variableName = data.substring(1, data.length() - 1);
        FileExists fileExists = new FileExists(linenumber, variableName);
        return fileExists;
    }

}
