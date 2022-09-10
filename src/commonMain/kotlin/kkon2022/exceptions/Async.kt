package kkon2022.exceptions

import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope

suspend fun inner() = coroutineScope {
    try {
        async {
            throw MyException()
        }.await()
    } catch (e: MyException) {
        println("inner $e")
    }
}
