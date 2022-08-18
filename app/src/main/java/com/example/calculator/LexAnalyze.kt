package com.example.calculator

class LexAnalyze {
    fun lexemParse(exp: String): List<Lexeme> {
        val lexemes: MutableList<Lexeme> = mutableListOf()
        var i = 0
        while (i < exp.length) {
            while (i < exp.length && exp[i] == ' ') {
                i++
                continue
            }
            var newLexemeName = ""
            if (exp[i] == '(') {
                lexemes += Lexeme(exp[i].toString(), LexemeType.OPENING_BRACKET)
                i++
            } else if (exp[i] == ')') {
                lexemes += Lexeme(exp[i].toString(), LexemeType.CLOSING_BRACKET)
                i++
            } else if (exp[i] == '+') {
                lexemes += Lexeme(exp[i].toString(), LexemeType.PLUS)
                i++
            } else if (exp[i] == '-') {
                lexemes += Lexeme(exp[i].toString(), LexemeType.MINUS)
                i++
            } else if (exp[i] == '*') {
                lexemes += Lexeme(exp[i].toString(), LexemeType.MULTIPLICATION)
                i++
            } else if (exp[i] == '/') {
                lexemes += Lexeme(exp[i].toString(), LexemeType.DIVISION)
                i++
            } else if (exp[i] in '0'..'9') {
                newLexemeName += exp[i]
                i++
                while ((i < exp.length && exp[i] in '0'..'9') || (i < exp.length && exp[i] == '.')) {
                    newLexemeName += exp[i]
                    i++
                }
                lexemes += Lexeme(newLexemeName, LexemeType.NUMBER)
            }
        }
        lexemes += Lexeme("", LexemeType.END_EXPRESSION)
        return lexemes
    }
}



