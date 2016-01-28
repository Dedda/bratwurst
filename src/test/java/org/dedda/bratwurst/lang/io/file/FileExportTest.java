package org.dedda.bratwurst.lang.io.file;

import org.dedda.bratwurst.FileSystemTestCase;
import org.dedda.bratwurst.lang.BWString;
import org.dedda.bratwurst.lang.BWVariable;
import org.dedda.bratwurst.lang.scope.Scope;
import org.junit.Test;

import java.io.File;


/**
 * Created by dedda on 1/27/16.
 *
 * @author dedda
 */
public class FileExportTest extends FileSystemTestCase {

    @Test
    public void testRun() throws Exception {
        String filename = genericFileName();
        String content = "Some text here to prove the system works!";
        File file = new File(filename);
        createFile(file, FORCE_FRESH);
        Scope scope = createEmptyScope();
        scope.setVariable(new BWVariable("content", new BWString(content)));
        scope.setVariable(new BWVariable("filename", new BWString(filename)));
        FileExport fileExport = new FileExport(0, "content", "filename");
        fileExport.run(scope);
        assertNotEmpty(file);
        assertContentEquals(file, content);
        removeFile(file);
    }
}