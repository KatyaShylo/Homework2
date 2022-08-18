package com.example.calculator

data class LexemeBuffer(private val lexemes: List<Lexeme>) {
    var i = 0
        private set

    operator fun next(): Lexeme {
        return lexemes[i++]
    }

    fun back() {
        i--
    }
}
