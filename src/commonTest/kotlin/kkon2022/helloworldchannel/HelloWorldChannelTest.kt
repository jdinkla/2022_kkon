package kkon2022.helloworldchannel

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldContainInOrder
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.toList

class HelloWorldChannelTest : StringSpec({
    coroutineTestScope = true
    "should say hello world" {
        // Given - Arrange
        val channel = Channel<String>(Channel.UNLIMITED)

        // When - Act
        helloWorld(channel)
        channel.close()

        // Then - Assert
        channel.toList() shouldContainInOrder listOf("Hello", "World!")
    }
})
