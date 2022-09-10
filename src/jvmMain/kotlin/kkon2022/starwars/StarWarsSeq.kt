package kkon2022.starwars

import io.ktor.client.call.body
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

suspend fun createPersonSeq(client: Client, url: String): Person = coroutineScope {
    val dto = client.get(url).body<PersonDto>()
    val films = dto.films.map {
        client.get(it).body<Film>()
    }
    Person(dto.name, films)
}

fun main() {
    val client = Client()
    val results = (1..5).map {
        val ms = measureTimeMillis {
            runBlocking {
                val person = createPersonSeq(client, "https://swapi.dev/api/people/1")
                println(person)
            }
        }
        Thread.sleep(250L)
        ms
    }
    println("results: $results")
    client.close()
}
