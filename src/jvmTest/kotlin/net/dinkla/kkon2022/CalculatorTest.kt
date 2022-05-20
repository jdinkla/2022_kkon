package net.dinkla.kkon2022

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class CalculatorTest : FunSpec({

    test("add") {
        val c = Calculator(20)
        c.add(10)
        c.value shouldBe 30
    }
})
