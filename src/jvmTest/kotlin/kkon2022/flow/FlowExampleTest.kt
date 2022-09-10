package kkon2022.flow

import app.cash.turbine.test
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class FlowExampleTest : StringSpec({
    "flow should return 1, 2 and 3" {
        // Given - Arrange
        // When - Act
        val flow = produce()

        // Then - Assert
        flow.test {
            awaitItem() shouldBe 1
            awaitItem() shouldBe 2
            awaitItem() shouldBe 3
            awaitComplete()
        }
    }
})
