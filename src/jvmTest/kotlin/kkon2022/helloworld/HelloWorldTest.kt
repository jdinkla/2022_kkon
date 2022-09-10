package kkon2022.helloworld

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.longs.shouldBeLessThan
import kkon2022.helloworld.helloWorld
import kotlin.system.measureTimeMillis

class HelloWorldTest : StringSpec({
    coroutineTestScope = true
    "should say hello world" {
        // Given - Arrange
        // When - Act
        val ms = measureTimeMillis {
            helloWorld()
        }
        // Then - Assert
        ms shouldBeLessThan 25
    }
})
