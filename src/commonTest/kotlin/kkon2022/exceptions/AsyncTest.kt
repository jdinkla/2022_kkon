package kkon2022.exceptions

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec

class AsyncTest : StringSpec({
    "async should throw" {
        shouldThrow<MyException> {
            inner()
        }
    }
})
