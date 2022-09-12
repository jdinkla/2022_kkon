package kkon2022.helloworldchannel

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.channels.shouldHaveSize
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.Channel

@OptIn(ExperimentalCoroutinesApi::class)
class HelloWorldChannelMatcherTest : StringSpec({
    coroutineTestScope = true
    "should have two elements" {
        // Given - Arrange
        val channel = Channel<String>(Channel.UNLIMITED)

        // When - Act
        helloWorld(channel)
        channel.close()

        // Then - Assert
        channel.shouldHaveSize(2)
    }
})
