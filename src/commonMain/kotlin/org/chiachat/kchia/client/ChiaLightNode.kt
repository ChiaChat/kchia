package org.chiachat.kchia.client

import io.ktor.client.*
import io.ktor.client.features.websocket.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*

class ChiaLightNode(val nodeSettings: NodeSettings) {
    val client = HttpClient {
        install(WebSockets) { }
    }

    suspend fun testRequest(): HttpResponse {
//        client.webSocket(method = HttpMethod)
    }
}
