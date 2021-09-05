package org.chiachat.kchia.manager

enum class ServiceType(private val argumentName: String? = null) {
    ALL,
    DAEMON,
    NODE,
    WALLET,
    WALLET_ONLY("wallet-only"),
    HARVESTER,
    FARMER,
    FARMER_NO_WALLET("farmer-no-wallet"),
    FARMER_ONLY("farmer-only"),
    TIMELORD,
    TIMELORD_ONLY("timelord-only"),
    TIMELORD_LAUNCHER_ONLY("timelord-launcher-only"),
    INTRODUCER,
    SIMULATOR,
    ;

    fun toChiaArg(): String = argumentName ?: name.lowercase()
}
