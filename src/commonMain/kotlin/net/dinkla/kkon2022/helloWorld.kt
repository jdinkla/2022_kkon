package net.dinkla.kkon2022

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

suspend fun helloWorld() = coroutineScope {
    launch {
        delay(1000)
        println("World!")
    }
    println("Hello")
}

