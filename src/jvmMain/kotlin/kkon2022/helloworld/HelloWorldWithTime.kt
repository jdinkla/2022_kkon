package kkon2022.helloworld

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

fun main() = runBlocking {
    val ms = measureTimeMillis {
        launch {
            delay(1000L)
            println("World!")
        }
        println("Hello")
    }
    println("took $ms ms")
}

