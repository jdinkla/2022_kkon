package kkon2022.dollar

class Dollar(val amount: Int) {
    operator fun times(value: Int): Dollar = Dollar(amount * value)
}
