package org.chiachat.kchia.client

import io.ktor.client.statement.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class ChiaLightNodeTest {
    val node = ChiaLightNode(NodeSettings(listOf(ChiaPeer("chianames.org", 8444))))

    @Test
    fun testRequest() {
        runBlocking {
            CoroutineScope(Dispatchers.IO)
            val response = node.testRequest()
            assertTrue(true)
        }
    }
}
