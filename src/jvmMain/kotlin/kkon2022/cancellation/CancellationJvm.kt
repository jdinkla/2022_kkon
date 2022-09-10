package kkon2022.cancellation

import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val job = createJob(1000L)
    timeOut(job, 100L)
    job.join()
}
