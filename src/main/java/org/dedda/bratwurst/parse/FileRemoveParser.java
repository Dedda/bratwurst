package org.dedda.bratwurst.parse;

import org.dedda.bratwurst.lang.io.file.FileRemove;

/**
 * Created by dedda on 1/25/16.
 *
 * @author dedda
 */
public class FileRemoveParser extends InstructionParser {

    @Override
    public FileRemove parse(String line, int lineNumber) {
        String variableName = line.substring(1, line.length() - 1);
        return new FileRemove(lineNumber, variableName);
    }
}
