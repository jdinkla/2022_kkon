package net.dinkla.kkon2022

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    launch {
        delay(1000)
        println("Kotlin Coroutines World!")
    }
    println("Hello")
}
