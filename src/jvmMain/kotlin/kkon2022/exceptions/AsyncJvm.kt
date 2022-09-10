package kkon2022.exceptions

import kotlinx.coroutines.runBlocking

fun main() {
    try {
        runBlocking {
            inner()
        }
    } catch (e: MyException) {
        println("outer $e")
    }
}
