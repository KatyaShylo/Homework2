package com.example.calculator

enum class LexemeType {
    OPENING_BRACKET, CLOSING_BRACKET,
    NUMBER,
    PLUS, MINUS, MULTIPLICATION, DIVISION,
    END_EXPRESSION
}

data class Lexeme(val value: String = "", val type: LexemeType = LexemeType.NUMBER) {
    override fun toString(): String {
        return value
    }
}
