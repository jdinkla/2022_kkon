package kkon2022.exceptions

import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.runBlocking

suspend fun inner() = coroutineScope {
    try {
        async {
            throw MyException()
        }.await()
    } catch (e: MyException) {
        println("inner $e")
    }
}

fun main() {
    try {
        runBlocking {
            inner()
        }
    } catch (e: MyException) {
        println("outer $e")
    }
}
