package kkon2022.ui

import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class Counter(
    override val coroutineContext: CoroutineContext,
    private val callback: (Int) -> Unit
) : CoroutineScope {

    private var job: Job? = null

    fun start() {
        job = createJob()
    }

    fun cancel() = job?.cancel()

    private fun CoroutineScope.createJob(): Job = launch {
        var counter = 0
        while (isActive) {
            println("set: $counter")
            callback(counter)
            delay(1000L)
            counter += 1
        }
    }
}
