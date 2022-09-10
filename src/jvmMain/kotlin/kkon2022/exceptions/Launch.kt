package kkon2022.exceptions

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

suspend fun innerLaunch() = coroutineScope {
    try {
        launch {
            throw MyException()
        }.join()
    } catch (e: MyException) {
        println("inner $e")
    }
}

fun main() {
    try {
        runBlocking {
            innerLaunch()
        }
    } catch (e: MyException) {
        println("outer $e")
    }
}
