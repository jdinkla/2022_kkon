package kkon2022.exceptions

import kotlinx.coroutines.runBlocking

fun main() {
    try {
        runBlocking {
            innerLaunch()
        }
    } catch (e: MyException) {
        println("outer $e")
    }
}
