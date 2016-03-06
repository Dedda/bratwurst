package org.dedda.bratwurst.parse;

import org.dedda.bratwurst.lang.io.file.FileExport;

/**
 * Created by dedda on 1/25/16.
 *
 * @author dedda
 */
public class FileExportParser extends InstructionParser {

    @Override
    public FileExport parse(String line, int lineNumber) {
        String[] split = line.split(" ");
        String dataVarName = split[0].substring(2);
        String destVarName = split[2].substring(0, split[2].length() - 2);
        return new FileExport(lineNumber, dataVarName, destVarName);
    }
}
