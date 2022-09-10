package kkon2022.starwars

import kotlinx.serialization.Serializable

@Serializable
data class PersonDto(
    val name: String,
    val films: List<String>
)

@Serializable
data class Film(val title: String) {
    override fun toString(): String = title
}

data class Person(
    val name: String,
    val films: List<Film>
)
