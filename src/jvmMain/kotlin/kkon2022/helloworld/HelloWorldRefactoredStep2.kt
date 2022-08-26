package kkon2022.helloworld

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

suspend fun helloWorld2() = coroutineScope {
    val list = mutableListOf<String>()
    launch {
        delay(1000L)
        list.add("World!")
    }
    list.add("Hello")
    list
}

fun main() = run {
    val ls = runBlocking {
        helloWorld2()
    }
    println(ls.joinToString(" "))
}

