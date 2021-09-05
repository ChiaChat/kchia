package org.chiachat.kchia.manager

import okio.ExperimentalFileSystem
import okio.FileSystem
import okio.Path
import okio.Path.Companion.toPath

@ExperimentalFileSystem
class ChiaLocator {
    private val fs = FileSystem.SYSTEM
    private val homeDir = System.getProperty("user.home")

    fun getPath(): Path? {
        if (fs.exists(LINUX_CHIA_PATH.toPath())) return LINUX_CHIA_PATH.toPath()
        if (fs.exists(MAC_CHIA_PATH.toPath())) return MAC_CHIA_PATH.toPath()
        if (fs.exists(WINDOWS_CHIA_PATH.toPath())) return WINDOWS_CHIA_PATH.toPath()
        return null
    }

    fun getWindowsPath(): Path? {
        val chiaAppData = "$homeDir/AppData/Local/chia-blockchain/".toPath()
        // List the files/folders in the chia-blockchain folder
        val test = fs.list(chiaAppData).forEach {
            println(it.name.contains("app-"))
        }
        fs.list(chiaAppData)
            // Grab the latest version chia folder if any: "app-1.x.x"
            .lastOrNull { it.name.contains("app-") }?.let {
                // If the binary is found at that path, return it
                val path = ("$it/resources/app.asar.unpacked/daemon/chia.exe").toPath()
                if (fs.exists(path)) return path
            }
        // Otherwise, return null
        return null
    }

    companion object {
        const val LINUX_CHIA_PATH = "/usr/lib/chia-blockchain/resources/app.asar.unpacked/daemon/chia"
        const val MAC_CHIA_PATH = "/Applications/Chia.app/Contents/Resources/app.asar.unpacked/daemon/chia"
        const val WINDOWS_CHIA_PATH = ""
    }
}
