package org.dedda.bratwurst.parse;

import org.dedda.bratwurst.lang.io.file.FileCreate;

/**
 * Created by dedda on 1/25/16.
 *
 * @author dedda
 */
public class FileCreateParser extends InstructionParser {

    @Override
    public FileCreate parse(String line, int lineNumber) {
        String variableName = line.substring(1, line.length() - 1);
        return new FileCreate(lineNumber, variableName);
    }

}
