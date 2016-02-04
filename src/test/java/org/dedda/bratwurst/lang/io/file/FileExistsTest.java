package org.dedda.bratwurst.lang.io.file;

import org.dedda.bratwurst.FileSystemTestCase;
import org.dedda.bratwurst.lang.BWString;
import org.dedda.bratwurst.lang.BWVariable;
import org.dedda.bratwurst.lang.scope.Scope;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertEquals;

/**
 * Created by dedda on 1/27/16.
 *
 * @author dedda
 */
public class FileExistsTest extends FileSystemTestCase {

    @Test
    public void testRun() throws Exception {
        final String filename = genericFileName();
        File file = new File(filename);
        createFile(file);
        Scope scope = createEmptyScope();
        scope.setVariable(new BWVariable("var", new BWString(filename)));
        FileExists fileExists = new FileExists(0, "var");
        fileExists.run(scope);
        assertEquals("File not found", 1, fileExists.getIntValue());
        removeFile(file);
        fileExists.run(scope);
        assertEquals("File found", 0, fileExists.getIntValue());
    }
}