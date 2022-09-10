package kkon2022.cancellation

import kotlinx.coroutines.*

fun CoroutineScope.createJob(ms: Long) = launch {
    try {
        delay(ms)
        println("job finished")
    } catch (e: CancellationException) {
        println("job was cancelled")
    }
}

suspend fun timeOut(job: Job, ms: Long) = coroutineScope {
    delay(ms)
    if (job.isActive) {
        job.cancel()
    }
}

fun main() = runBlocking {
    val job = createJob(1000L)
    timeOut(job, 100L)
    job.join()
}
