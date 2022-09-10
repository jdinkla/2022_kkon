package kkon2022.helloworldchannel

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

suspend fun helloWorld(channel: Channel<String>) = coroutineScope {
    launch {
        delay(1000L)
        channel.send("World!")
    }
    channel.send("Hello")
}
