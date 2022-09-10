package kkon2022.helloworld

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.longs.shouldBeGreaterThan
import kkon2022.helloworld.helloWorld
import kotlin.system.measureTimeMillis

class SlowHelloWorldTest : StringSpec({
    "should say hello world" {
        // Given - Arrange
        // When - Act
        val ms = measureTimeMillis {
            helloWorld()
        }
        println("took $ms ms")

        // Then - Assert
        ms shouldBeGreaterThan 1000
    }
})
