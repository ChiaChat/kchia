package org.chiachat.kchia

import okio.ExperimentalFileSystem
import org.chiachat.kchia.manager.ChiaLocator
import org.chiachat.kchia.util.OSValidator
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

@OptIn(ExperimentalFileSystem::class)
internal class ChiaLocatorTest {

    private val locator = ChiaLocator()

    fun getPath() {
        val path = locator.getPath()
        assertTrue(path != null)
    }

    fun getWindowsPath() {
        if(!OSValidator.isWindows) return
        val pathValidator = Regex(
            """
            .+Users[\/\\].+[\/\\]AppData[\/\\]Local[\/\\]chia-blockchain[\/\\]app-.+[\/\\]resources[\/\\]app\.asar\.unpacked[\/\\]daemon[\/\\]chia\.exe
            """.trimIndent()
        )
        val windowsPath = locator.getWindowsPath()
        assertTrue(pathValidator.containsMatchIn(windowsPath.toString()))
    }
}
