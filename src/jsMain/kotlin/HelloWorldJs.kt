import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

suspend fun main() = coroutineScope {
    launch {
        delay(1000)
        println("Kotlin Coroutines World!")
    }
    println("Hello")
}

