package org.dedda.bratwurst.lang.io.file

import org.dedda.bratwurst.FileSystemTestCase
import org.dedda.bratwurst.lang.BWString
import org.dedda.bratwurst.lang.BWVariable
import org.testng.annotations.Test
import java.io.File

/**
 * Created by dedda on 1/27/16.
 *
 * @author dedda
 */
class FileExportTest : FileSystemTestCase() {
    @Test
    @Throws(Exception::class)
    fun testRun() {
        val filename = genericFileName()
        val content = "Some text here to prove the system works!"
        val file = File(filename)
        createFile(file, FORCE_FRESH)
        val scope = createEmptyScope()
        scope.setVariable(BWVariable("content", BWString(content)))
        scope.setVariable(BWVariable("filename", BWString(filename)))
        val fileExport = FileExport(0, "content", "filename")
        fileExport.run(scope)
        assertNotEmpty(file)
        assertContentEquals(file, content)
        removeFile(file)
    }
}