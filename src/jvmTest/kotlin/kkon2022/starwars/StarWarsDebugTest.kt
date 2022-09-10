package kkon2022.starwars

import io.kotest.core.spec.style.StringSpec
import io.ktor.client.call.body
import io.ktor.client.statement.HttpResponse
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.debug.DebugProbes

@OptIn(ExperimentalCoroutinesApi::class)
class StarWarsDebugTest : StringSpec({
    coroutineDebugProbes = true
    "should create a person from an URL" {
        // Given - Arrange
        DebugProbes.install()

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
        val person = createPerson(client, "someUrl")

        // Then - Assert
        DebugProbes.uninstall()
    }
})
