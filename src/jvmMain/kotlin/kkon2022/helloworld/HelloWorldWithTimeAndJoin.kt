package kkon2022.helloworld

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

fun main() = runBlocking {
    val ms = measureTimeMillis {
        val job = launch {
            delay(1000L)
            println("World!")
        }
        println("Hello")
        job.join()
    }
    println("took $ms ms")
}
