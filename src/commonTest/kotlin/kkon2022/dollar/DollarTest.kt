package kkon2022.dollar

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.blocking.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class DollarTest : StringSpec({
    "multiplying 5 Dollars by 2 should give 10" {
        // Given - Arrange
        val five = Dollar(5)

        // When - Act
        val result = five * 2

        // Then - Assert
        result.amount shouldBe 10
    }

    "multiplying 5 Dollars by N should give 5*N" {
        forAll(row(2, 10), row(3, 15)) { n, expected ->
            // Given - Arrange
            val five = Dollar(5)

            // When - Act
            val result = five * n

            // Then - Assert
            result.amount shouldBe expected
        }
    }
})

