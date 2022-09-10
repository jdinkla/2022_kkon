package kkon2022.starwars

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldContainAll
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.shouldBe
import io.ktor.client.call.body
import io.ktor.client.statement.HttpResponse
import io.mockk.coEvery
import io.mockk.coVerifyAll
import io.mockk.confirmVerified
import io.mockk.mockk

class StarWarsAsyncTest : StringSpec({
    "should create a person from an URL" {
        // Given - Arrange
        val dto = PersonDto("someName",
            listOf("someFilmURL", "someOtherFilmURL")
        )
        val film1 = Film("someFilm")
        val film2 = Film("someOtherFilm")

        val response = mockk<HttpResponse>()
        coEvery { response.body<PersonDto>() } returns dto
        coEvery { response.body<Film>() }.returnsMany(film1, film2)

        val client = mockk<Client>()
        coEvery { client.get("someUrl") } returns response
        coEvery { client.get("someFilmURL") } returns response
        coEvery { client.get("someOtherFilmURL") } returns response

        // When - Act
        val async = createPersonAsync(client, "someUrl")
        val person = async.await()

        // Then - Assert
        async.films shouldHaveSize dto.films.size
        person.name shouldBe dto.name
        person.films shouldContainAll listOf(film1, film2)
        coVerifyAll {
            client.get("someUrl")
            client.get("someFilmURL")
            client.get("someOtherFilmURL")
        }
        confirmVerified(client)
    }
})
