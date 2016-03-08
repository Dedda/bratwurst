package org.dedda.bratwurst;

import java.io.*;

import static org.testng.Assert.assertNotEquals;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

/**
 * Created by dedda on 1/27/16.
 *
 * @author dedda
 */
public class FileSystemTestCase extends ScopedTestCase {

    public static final boolean FORCE_FRESH = true;
    public static final boolean NOT_FORCE_FRESH = false;

    public String genericFileName() {
        return "testfile-" + this.getClass().getCanonicalName() + ":" + System.currentTimeMillis();
    }

    public void createFile(final File file, final String content) throws Exception {
        createFile(file, true);
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        writer.write(content);
        writer.flush();
        writer.close();
    }

    public void createFile(final File file) throws Exception {
        this.createFile(file, false);
    }

    public void createFile(final File file, final boolean forceFresh) throws Exception {
        if (!file.exists()) {
            file.createNewFile();
        } else if(forceFresh) {
            file.delete();
            file.createNewFile();
        }
        assertTrue("File could not be created", file.exists());
        if (forceFresh) {
            assertEmpty(file);
        }
    }

    public void removeFile(final File file) {
        if (file.exists()) {
            file.delete();
        }
        assertFalse("File could not be removed", file.exists());
    }

    public byte[] read(final File file) throws IOException {
        byte[] data = new byte[(int) file.length()];
        new FileInputStream(file).read(data);
        return data;
    }

    public void assertEmpty(final File file) {
        assertEquals("File not empty", 0, file.length());
    }

    public void assertNotEmpty(final File file) {
        assertNotEquals(0, file.length());
    }

    public void assertContentEquals(final File file, final String expected) throws Exception {
        String read = new String(read(file));
        assertEquals("Content not equal", expected, read);
    }

}
