package kkon2022.helloworldchannel

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

@OptIn(ExperimentalCoroutinesApi::class)
suspend fun main() = runBlocking {
    val channel = Channel<String>()
    val job = launch {
        helloWorld(channel)
    }
    while (!channel.isClosedForReceive) {
        println(channel.receive())
    }
    job.join()
}
