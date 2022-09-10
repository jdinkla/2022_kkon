package kkon2022.helloworld

import kotlinx.coroutines.delay
import kotlinx.coroutines.joinAll
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

fun main() = runBlocking {
    val ms = measureTimeMillis {
        val jobs = (1..5).map { id ->
            launch {
                delay(1000L)
                println("World $id")
            }
        }
        println("Hello")
        jobs.joinAll()
    }
    println("took $ms ms")
}
