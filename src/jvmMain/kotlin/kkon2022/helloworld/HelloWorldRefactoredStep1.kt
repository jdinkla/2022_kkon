package kkon2022.helloworld

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

suspend fun helloWorld1() = coroutineScope {
    launch {
        delay(1000L)
        println("World!")
    }
    println("Hello")
}

fun main() = runBlocking {
    helloWorld1()
}
