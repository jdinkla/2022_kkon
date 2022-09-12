package kkon2022

import kkon2022.helloworld.helloWorld
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    println("From Linux")
    helloWorld()
}
