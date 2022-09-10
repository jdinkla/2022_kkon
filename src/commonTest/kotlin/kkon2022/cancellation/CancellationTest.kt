package kkon2022.cancellation

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.sequences.shouldHaveSize
import io.kotest.matchers.shouldBe

class CancellationTest : StringSpec({
    coroutineTestScope = true
    "should time out a job" {
        val job = createJob(100L)
        // When - Act
        timeOut(job, 10L)
        // Then - Assert
        job.children shouldHaveSize 0
        job.isCancelled shouldBe true
        job.isCompleted shouldBe false
    }
    "should not time out a job" {
        val job = createJob(100L)
        // When - Act
        timeOut(job, 200L)
        // Then - Assert
        job.isCancelled shouldBe false
        job.isCompleted shouldBe true
    }
    "should create a job" {
        // When - Act
        val job = createJob(100L)
        // Then - Assert
        job.isCancelled shouldBe false
        job.children shouldHaveSize 0
        job.isCompleted shouldBe false
    }
})
