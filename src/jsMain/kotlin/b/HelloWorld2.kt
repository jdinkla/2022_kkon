package b

import kotlinx.coroutines.coroutineScope
import net.dinkla.kkon2022.helloWorld

suspend fun main() = coroutineScope {
   println("b")
   helloWorld()
   helloWorld()
}

