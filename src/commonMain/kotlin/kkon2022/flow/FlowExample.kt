package kkon2022.flow

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

suspend fun produce() = flow {
    println("start")
    for (i in 1..3) {
        println("emit $i")
        emit(i)
    }
    println("stop")
}

suspend fun consume(flow: Flow<Int>) {
    println("start consuming  ...")
    flow.map { it * 10 }
        .collect() {
            println("collected $it")
        }
}
