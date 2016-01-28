package org.dedda.bratwurst.lang.io.file;

import org.dedda.bratwurst.FileSystemTestCase;
import org.dedda.bratwurst.lang.BWString;
import org.dedda.bratwurst.lang.BWVariable;
import org.dedda.bratwurst.lang.scope.Scope;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

/**
 * Created by dedda on 1/28/16.
 *
 * @author dedda
 */
public class FileRemoveTest extends FileSystemTestCase {

    @Test
    public void testRun() throws Exception {
        String filename = genericFileName();
        File file = new File(filename);
        createFile(file);
        Scope scope = createEmptyScope();
        scope.setVariable(new BWVariable("var", new BWString(filename)));
        FileRemove fileRemove = new FileRemove(0, "var");
        fileRemove.run(scope);
        assertFalse("File was not removed", file.exists());
        removeFile(file);
    }
}