package kkon2022.exceptions

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

suspend fun innerLaunch() = coroutineScope {
    try {
        launch {
            throw MyException()
        }.join()
    } catch (e: MyException) {
        println("inner $e")
    }
}
