package c

import kkon2022.helloworld.helloWorld
import kotlinx.coroutines.coroutineScope

suspend fun main() = coroutineScope {
   println("c")
   helloWorld()
}

