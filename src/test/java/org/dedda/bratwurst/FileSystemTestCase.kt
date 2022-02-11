package org.dedda.bratwurst

import org.testng.AssertJUnit
import java.io.*

/**
 * Created by dedda on 1/27/16.
 *
 * @author dedda
 */
open class FileSystemTestCase : ScopedTestCase() {
    fun genericFileName(): String {
        return "testfile-" + this.javaClass.canonicalName + ":" + System.currentTimeMillis()
    }

    @Throws(Exception::class)
    fun createFile(file: File, content: String?) {
        createFile(file, true)
        val writer = BufferedWriter(FileWriter(file))
        writer.write(content)
        writer.flush()
        writer.close()
    }

    @JvmOverloads
    @Throws(Exception::class)
    fun createFile(file: File, forceFresh: Boolean = false) {
        if (!file.exists()) {
            file.createNewFile()
        } else if (forceFresh) {
            file.delete()
            file.createNewFile()
        }
        AssertJUnit.assertTrue("File could not be created", file.exists())
        if (forceFresh) {
            assertEmpty(file)
        }
    }

    fun removeFile(file: File) {
        if (file.exists()) {
            file.delete()
        }
        AssertJUnit.assertFalse("File could not be removed", file.exists())
    }

    fun assertEmpty(file: File) {
        AssertJUnit.assertEquals("File not empty", 0, file.length())
    }

    fun assertNotEmpty(file: File) {
        assert(0L != file.length())
    }

    @Throws(Exception::class)
    fun assertContentEquals(file: File?, expected: String?) {
        val reader = BufferedReader(FileReader(file))
        var read: String? = ""
        var buffer: String?
        while (reader.readLine().also { buffer = it } != null) {
            read += buffer
        }
        reader.close()
        AssertJUnit.assertEquals("Content not equal", expected, read)
    }

    companion object {
        const val FORCE_FRESH = true
        const val NOT_FORCE_FRESH = false
    }
}