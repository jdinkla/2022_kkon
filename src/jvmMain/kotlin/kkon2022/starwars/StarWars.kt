package kkon2022.starwars

import io.ktor.client.call.body
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

suspend fun createPerson(client: Client, url: String): Person = coroutineScope {
    val dto = client.get(url).body<PersonDto>()
    val films = dto.films.map {
        async {
            client.get(it).body<Film>()
        }
    }
    Person(dto.name, films.awaitAll())
}

fun main() {
    val client = Client()
    val ms = measureTimeMillis {
        runBlocking {
            val person = createPerson(client, "https://swapi.dev/api/people/1")
            println(person)
        }
    }
    println("took $ms ms")
    client.close()
}
