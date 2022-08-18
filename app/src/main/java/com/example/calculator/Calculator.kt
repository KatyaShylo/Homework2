package com.example.calculator

class Calculator {

    fun conventAndResult(expression: String): Double { // разделение выражения на пробелы и вывод результата
        var strExpression = expression
        val finalExpressionToCalc = StringBuilder()
        var changedString = ""
        while (strExpression.isNotEmpty()) {
            var elementExpression = strExpression[0]
            when (elementExpression) {
                '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '.' -> {
                    finalExpressionToCalc.append(elementExpression)
                    changedString = strExpression.substring(1)
                    strExpression = changedString
                }
                '+', '-', '/', '*', '(', ')' -> {
                    finalExpressionToCalc.append(" ").append(elementExpression).append(" ")
                    changedString = strExpression.substring(1)
                    strExpression = changedString
                }
            }
        }


        val lexemes = LexAnalyze().lexemParse(
            finalExpressionToCalc.toString().replace("  ".toRegex(), " ").trim()
        )
        val lexemeBuffer = LexemeBuffer(lexemes)
        return expressionResult(lexemeBuffer)
    }


    fun expressionResult(lexemes: LexemeBuffer): Double {
        val lexeme = lexemes.next()
        return if (lexeme.type == LexemeType.END_EXPRESSION) {
            0.0
        } else {
            lexemes.back()
            plusAndMinus(lexemes)
        }
    }

    fun plusAndMinus(lexemes: LexemeBuffer): Double {
        var value = multiplicationAndDivision(lexemes)
        while (true) {
            val lexeme = lexemes.next()
            when (lexeme.type) {
                LexemeType.PLUS -> value += multiplicationAndDivision(lexemes)
                LexemeType.MINUS -> value -= multiplicationAndDivision(lexemes)
                LexemeType.END_EXPRESSION, LexemeType.CLOSING_BRACKET -> {
                    lexemes.back()
                    return value
                }
                else -> throw RuntimeException(
                    "Unexpected lexem: " + lexeme.value + " at position: " + lexemes.i
                )
            }
        }
    }

    fun multiplicationAndDivision(lexemes: LexemeBuffer): Double {
        var value = factor(lexemes)
        while (true) {
            val lexeme = lexemes.next()
            when (lexeme.type) {
                LexemeType.MULTIPLICATION -> value *= factor(lexemes)
                LexemeType.DIVISION -> value /= factor(lexemes)
                LexemeType.END_EXPRESSION, LexemeType.CLOSING_BRACKET, LexemeType.PLUS, LexemeType.MINUS -> {
                    lexemes.back()
                    return value
                }
                else -> throw RuntimeException(
                    "Unexpected lexem: " + lexeme.value + " at position: " + lexemes.i
                )
            }
        }
    }

    fun factor(lexemes: LexemeBuffer): Double {
        var lexeme = lexemes.next()
        return when (lexeme.type) {
            LexemeType.NUMBER -> lexeme.value.toDouble()
            LexemeType.OPENING_BRACKET -> {
                val value = plusAndMinus(lexemes)
                lexeme = lexemes.next()
                if (lexeme.type != LexemeType.CLOSING_BRACKET) {
                    throw RuntimeException(
                        "Unexpected lexem: " + lexeme.value + " at position: " + lexemes.i
                    )
                }
                value
            }
            else -> throw RuntimeException(
                "Unexpected lexem: " + lexeme.value + " at position: " + lexemes.i
            )
        }
    }
}



