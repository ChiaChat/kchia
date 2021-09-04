package org.chiachat.kchia

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class ChiaLocatorTest {

    @Test
    fun getPath() {
    }

    @Test
    fun getWindowsPath() {
        val pathValidator = Regex(
            """
            Users[\/\\].+[\/\\]AppData[\/\\]Local[\/\\]chia-blockchain[\/\\]app-.+[\/\\]resources[\/\\]app\.asar\.unpacked[\/\\]daemon[\/\\]chia\.exe 
            """.trimIndent()
        )
    }
}
