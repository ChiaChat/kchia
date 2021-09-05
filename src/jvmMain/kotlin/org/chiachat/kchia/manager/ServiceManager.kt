package org.chiachat.kchia.manager

import okio.ExperimentalFileSystem
import okio.Path
import java.io.File

@ExperimentalFileSystem
class ServiceManager(val chiaPath: Path) {

    private val processes: MutableMap<ServiceType, Process?> = mutableMapOf()

    fun start(service: ServiceType){
        processes[service] = runCommand("start", service.toChiaArg())
    }

    fun stop(service: ServiceType) {
        runCommand("stop", service.toChiaArg())
        processes[service] = null
    }

    fun runCommand(vararg chiaArgs: String): Process{
        return runCommand(*chiaArgs)
    }

    fun runCommand(
        chiaArgs: List<String>,
        redirectInput: File? = null,
        redirectOutput: File? = null,
        redirectError: File? = null
    ): Process {
        val process = ProcessBuilder(chiaArgs)
        if(redirectInput != null){
            process.redirectInput(redirectInput)
        }
        if(redirectOutput != null){
            process.redirectOutput(redirectOutput)
        }
        if(redirectError != null){
            process.redirectError(redirectError)
        }
        return process.start()
    }

    fun isRunning(service: ServiceType): Boolean {
        return processes[service] != null
    }
}
