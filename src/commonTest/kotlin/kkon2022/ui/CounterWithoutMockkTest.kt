package kkon2022.ui

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldContainInOrder
import io.kotest.matchers.shouldBe
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.advanceTimeBy
import kotlinx.coroutines.test.currentTime
import kotlinx.coroutines.test.runTest

@OptIn(ExperimentalCoroutinesApi::class)
class CounterWithoutMockkTest : StringSpec({
    "start call callback three times in three seconds" {
        // Given - Arrange
        val recorded = mutableListOf<Int>()
        val callback: (Int) -> Unit = { recorded.add(it) }

        // When - Act
        runTest {
            val counter = Counter(this.coroutineContext, callback)
            counter.start()
            currentTime shouldBe 0L
            advanceTimeBy(3000L)
            currentTime shouldBe 3000L
            counter.cancel()
        }

        // Then - Assert
        recorded shouldContainInOrder listOf(0, 1, 2)
    }
})
