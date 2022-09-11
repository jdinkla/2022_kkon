package kkon2022.flow

import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    consume(produce())
}
