package net.dinkla.kkon2022

class Calculator(var value: Int) {

    fun add(value: Int) {
        this.value += value
    }

    fun multiply(value: Int) {
        this.value *= value
    }

}