package kkon2022.swing

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.mockk.mockk
import io.mockk.verifyAll
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.advanceTimeBy
import kotlinx.coroutines.test.currentTime
import kotlinx.coroutines.test.runTest

@OptIn(ExperimentalCoroutinesApi::class)
class CounterTest : StringSpec({
    "start call callback three times in three seconds" {
        // Given - Arrange
        val callback : (Int) -> Unit = mockk(relaxed = true)

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
        verifyAll {
            callback.invoke(0)
            callback.invoke(1)
            callback.invoke(2)
        }
    }
})
