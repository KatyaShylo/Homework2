package com.example.calculator

import android.os.Bundle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.calculator.databinding.FragmentCalculatorBinding
import java.util.*

class CalculatorFragment : Fragment() {

    private var _binding: FragmentCalculatorBinding? = null
    private val binding: FragmentCalculatorBinding
        get() = requireNotNull(_binding)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentCalculatorBinding.inflate(inflater, container, false)
            .also { _binding = it }
            .root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val defaultMessage = "enter the expression"
        with(binding) {
            val calculatorElements = listOf(
                buttonNumberOne, buttonNumberTwo, buttonNumberThree, buttonNumberFour,
                buttonNumberFive, buttonNumberSix, buttonNumberSeven, buttonNumberEight,
                buttonNumberNine, buttonNumberZero, buttonPlus, buttonDivision, buttonMinus,
                buttonMultiplication, buttonPoint, buttonOpeningBracket, buttonClosingBracket,
                buttonDeleteAll, buttonDeleteOnePosition, buttonEqualSign
            )
            val clickListener = View.OnClickListener { it ->
                when (it.id) {
                    buttonNumberZero.id -> {
                        if (textViewExpression.text.toString() == defaultMessage) {
                            textViewExpression.text = buttonNumberZero.text
                        } else textViewExpression.append(buttonNumberZero.text)
                    }
                    buttonNumberOne.id -> {
                        if (textViewExpression.text.toString() == defaultMessage) {
                            textViewExpression.text = buttonNumberOne.text
                        } else textViewExpression.append(buttonNumberOne.text)
                    }
                    buttonNumberTwo.id -> {
                        if (textViewExpression.text.toString() == defaultMessage) {
                            textViewExpression.text = buttonNumberTwo.text
                        } else textViewExpression.append(buttonNumberTwo.text)
                    }
                    buttonNumberThree.id -> {
                        if (textViewExpression.text.toString() == defaultMessage) {
                            textViewExpression.text = buttonNumberThree.text
                        } else textViewExpression.append(buttonNumberThree.text)
                    }
                    buttonNumberFour.id -> {
                        if (textViewExpression.text.toString() == defaultMessage) {
                            textViewExpression.text = buttonNumberFour.text
                        } else textViewExpression.append(buttonNumberFour.text)
                    }
                    buttonNumberFive.id -> {
                        if (textViewExpression.text.toString() == defaultMessage) {
                            textViewExpression.text = buttonNumberFive.text
                        } else textViewExpression.append(buttonNumberFive.text)
                    }
                    buttonNumberSix.id -> {
                        if (textViewExpression.text.toString() == defaultMessage) {
                            textViewExpression.text = buttonNumberSix.text
                        } else textViewExpression.append(buttonNumberSix.text)
                    }
                    buttonNumberSeven.id -> {
                        if (textViewExpression.text.toString() == defaultMessage) {
                            textViewExpression.text = buttonNumberSeven.text
                        } else textViewExpression.append(buttonNumberSeven.text)
                    }
                    buttonNumberEight.id -> {
                        if (textViewExpression.text.toString() == defaultMessage) {
                            textViewExpression.text = buttonNumberEight.text
                        } else textViewExpression.append(buttonNumberEight.text)
                    }
                    buttonNumberNine.id -> {
                        if (textViewExpression.text.toString() == defaultMessage) {
                            textViewExpression.text = buttonNumberNine.text
                        } else textViewExpression.append(buttonNumberNine.text)
                    }
                    buttonPlus.id -> {
                        when {
                            textViewExpression.text.last() == '+' ||
                                    textViewExpression.text.last() == '-' ||
                                    textViewExpression.text.last() == '*' ||
                                    textViewExpression.text.last() == '/' ||
                                    textViewExpression.text.last() == '.' ||
                                    textViewExpression.text.last() == '(' -> {
                                Toast.makeText(
                                    requireContext(),
                                    "Please, check the correctness of the input.",
                                    Toast.LENGTH_SHORT
                                )
                                    .show()
                            }
                            textViewExpression.text.toString() == defaultMessage -> {
                                Toast.makeText(
                                    requireContext(),
                                    "You can't enter an operation first",
                                    Toast.LENGTH_SHORT
                                )
                                    .show()
                            }
                            else -> {
                                textViewExpression.append(buttonPlus.text)
                            }
                        }
                    }
                    buttonDivision.id -> {
                        when {
                            textViewExpression.text.last() == '+' ||
                                    textViewExpression.text.last() == '-' ||
                                    textViewExpression.text.last() == '*' ||
                                    textViewExpression.text.last() == '/' ||
                                    textViewExpression.text.last() == '.' ||
                                    textViewExpression.text.last() == '(' -> {
                                Toast.makeText(
                                    requireContext(),
                                    "Please, check the correctness of the input.",
                                    Toast.LENGTH_SHORT
                                )
                                    .show()
                            }
                            textViewExpression.text.toString() == defaultMessage -> {
                                Toast.makeText(
                                    requireContext(),
                                    "You can't enter an operation first",
                                    Toast.LENGTH_SHORT
                                )
                                    .show()
                            }
                            else -> {
                                textViewExpression.append(buttonDivision.text)
                            }
                        }
                    }
                    buttonMinus.id -> {
                        when {
                            textViewExpression.text.last() == '+' ||
                                    textViewExpression.text.last() == '-' ||
                                    textViewExpression.text.last() == '*' ||
                                    textViewExpression.text.last() == '/' ||
                                    textViewExpression.text.last() == '.' -> {
                                Toast.makeText(
                                    requireContext(),
                                    "Please, check the correctness of the input.",
                                    Toast.LENGTH_SHORT
                                )
                                    .show()
                            }
                            textViewExpression.text.toString() == defaultMessage -> {
                                Toast.makeText(
                                    requireContext(),
                                    "You can't enter an operation first. If you want " +
                                            "the first negstive number, enter for example '0-16'.",
                                    Toast.LENGTH_SHORT
                                )
                                    .show()
                            }
                            else -> {
                                textViewExpression.append(buttonMinus.text)
                            }
                        }
                    }
                    buttonMultiplication.id -> {
                        when {
                            textViewExpression.text.last() == '+' ||
                                    textViewExpression.text.last() == '-' ||
                                    textViewExpression.text.last() == '*' ||
                                    textViewExpression.text.last() == '/' ||
                                    textViewExpression.text.last() == '.' ||
                                    textViewExpression.text.last() == '(' -> {
                                Toast.makeText(
                                    requireContext(),
                                    "Please, check the correctness of the input.",
                                    Toast.LENGTH_SHORT
                                )
                                    .show()
                            }
                            textViewExpression.text.toString() == defaultMessage -> {
                                Toast.makeText(
                                    requireContext(),
                                    "You can't enter an operation first",
                                    Toast.LENGTH_SHORT
                                )
                                    .show()
                            }
                            else -> {
                                textViewExpression.append(buttonMultiplication.text)
                            }
                        }
                    }
                    buttonPoint.id -> {
                        when {
                            textViewExpression.text.last() == '+' ||
                                    textViewExpression.text.last() == '-' ||
                                    textViewExpression.text.last() == '*' ||
                                    textViewExpression.text.last() == '/' ||
                                    textViewExpression.text.last() == '.' ||
                                    textViewExpression.text.last() == '(' ||
                                    textViewExpression.text.last() == ')' -> {
                                Toast.makeText(
                                    requireContext(),
                                    "Please, check the correctness of the input.",
                                    Toast.LENGTH_SHORT
                                )
                                    .show()
                            }
                            textViewExpression.text.toString() == defaultMessage -> {
                                Toast.makeText(
                                    requireContext(),
                                    "You can't enter an operation first",
                                    Toast.LENGTH_SHORT
                                )
                                    .show()
                            }
                            else -> {
                                textViewExpression.append(buttonPoint.text)
                            }
                        }
                    }
                    buttonOpeningBracket.id -> {
                        when {
                            textViewExpression.text.last() == '.' ||
                                    textViewExpression.text.last() == ')' ||
                                    textViewExpression.text.last() == '1' ||
                                    textViewExpression.text.last() == '2' ||
                                    textViewExpression.text.last() == '3' ||
                                    textViewExpression.text.last() == '4' ||
                                    textViewExpression.text.last() == '5' ||
                                    textViewExpression.text.last() == '6' ||
                                    textViewExpression.text.last() == '7' ||
                                    textViewExpression.text.last() == '8' ||
                                    textViewExpression.text.last() == '9' ||
                                    textViewExpression.text.last() == '0' -> {
                                Toast.makeText(
                                    requireContext(),
                                    "Please, check the correctness of the input.",
                                    Toast.LENGTH_SHORT
                                )
                                    .show()
                            }
                            textViewExpression.text.toString() == defaultMessage -> {
                                textViewExpression.text = buttonOpeningBracket.text
                            }
                            else -> {
                                textViewExpression.append(buttonOpeningBracket.text)
                            }
                        }
                    }
                    buttonClosingBracket.id -> {
                        when {
                            textViewExpression.text.last() == '+' ||
                                    textViewExpression.text.last() == '-' ||
                                    textViewExpression.text.last() == '*' ||
                                    textViewExpression.text.last() == '/' ||
                                    textViewExpression.text.last() == '.' ||
                                    textViewExpression.text.last() == '(' -> {
                                Toast.makeText(
                                    requireContext(),
                                    "Please, check the correctness of the input.",
                                    Toast.LENGTH_SHORT
                                )
                                    .show()
                            }
                            textViewExpression.text.toString() == defaultMessage -> {
                                Toast.makeText(
                                    requireContext(),
                                    "You can't enter an operation first",
                                    Toast.LENGTH_SHORT
                                )
                                    .show()
                            }
                            else -> {
                                textViewExpression.append(buttonClosingBracket.text)
                            }
                        }
                    }
                    buttonDeleteAll.id -> {
                        textViewExpression.text = defaultMessage
                        textViewResult.text = ""
                    }
                    buttonDeleteOnePosition.id -> {
                        val stringExpression = textViewExpression.text.toString()
                        if (stringExpression.isNotEmpty()) {
                            textViewExpression.text =
                                stringExpression.substring(0, stringExpression.length - 1)

                        }
                    }
                    buttonEqualSign.id -> {
                        val bracket: Stack<Char> = Stack<Char>()
                        textViewExpression.text.forEach {
                            if (it == '(') bracket.push(it)
                            if (it == ')' && bracket.isNotEmpty()) bracket.pop()
                        }
                        if (bracket.isNotEmpty()) {
                            Toast.makeText(
                                activity,
                                "Please, verify count of your opening and closing brackets",
                                Toast.LENGTH_LONG
                            ).show()
                            return@OnClickListener
                        }
                        when {
                            textViewExpression.text.toString() == defaultMessage -> {
                                Toast.makeText(
                                    requireContext(),
                                    "Please, enter the expression.",
                                    Toast.LENGTH_SHORT
                                )
                                    .show()
                            }
                            textViewExpression.text.last() == '-' ||
                                    textViewExpression.text.last() == '+' ||
                                    textViewExpression.text.last() == '*' ||
                                    textViewExpression.text.last() == '/' -> {
                                Toast.makeText(
                                    requireContext(),
                                    "Please, check the correctness of the input.",
                                    Toast.LENGTH_SHORT
                                )
                                    .show()
                            }
                            else -> {
                                textViewResult.text =
                                    Calculator().conventAndResult(textViewExpression.text.toString())
                                        .toString()
                            }
                        }
                    }
                }
            }
            calculatorElements.forEach {
                it.setOnClickListener(clickListener)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}






