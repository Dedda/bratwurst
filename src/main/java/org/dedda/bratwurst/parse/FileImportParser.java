package org.dedda.bratwurst.parse;

import org.dedda.bratwurst.lang.BWInstruction;
import org.dedda.bratwurst.lang.io.file.FileImport;

/**
 * Created by dedda on 1/25/16.
 *
 * @author dedda
 */
public class FileImportParser extends InstructionParser {

    @Override
    public FileImport parse(String line, int lineNumber) {
        String variableName = line.substring(2, line.length() - 2);
        FileImport fileImport = new FileImport(lineNumber, variableName);
        return fileImport;
    }
}
