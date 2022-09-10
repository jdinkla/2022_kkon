package kkon2022.starwars

import io.ktor.client.call.body
import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

class PersonAsync(
    val name: String,
    val films: List<Deferred<Film>>
) {
    suspend fun await() = Person(name, films.awaitAll())
}

suspend fun createPersonAsync(client: Client, url: String) = coroutineScope {
    val dto = client.get(url).body<PersonDto>()
    val coroutines = dto.films.map {
        async {
            client.get(it).body<Film>()
        }
    }
    PersonAsync(dto.name, coroutines)
}

fun main() {
    val client = Client()
    val results = (1..5).map {
        measureTimeMillis {
            runBlocking {
                val person = createPersonAsync(client, "https://swapi.dev/api/people/1")
                println(person.await())
            }
        }
    }
    println("results: $results")
    client.close()
}
