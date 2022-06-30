package com.example.mycalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var canAddOperation = false
    private var canAddDecimal = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun numberAction(view: android.view.View) {
        if (view is Button) {
            if (view.text == ".") {
                if (canAddDecimal)
                    working_TV.append(view.text)
                canAddDecimal = false
            } else
                working_TV.append((view.text))
            canAddOperation = true
        }
    }

    fun operationAction(view: android.view.View) {
        if (view is Button && canAddOperation) {
            working_TV.append((view.text))
            canAddOperation = false
            canAddDecimal = true
        }
    }

    fun allClearAction(view: android.view.View) {
        working_TV.text = ""
        result_TV.text = ""
    }


    fun backSpaceAction(view: android.view.View) {
        val length = working_TV.length()
        if (length > 0) {
            working_TV.text = working_TV.text.subSequence(0, length - 1)
        }
    }

    fun equalsAction(view: android.view.View) {
        result_TV.text = calculatesResults()
    }

    private fun calculatesResults(): String {
        val digitOperator = digitsOperator()
        if (digitOperator.isEmpty()) return ""
        val timeDivision = timesDivisionCalculate(digitOperator)
        if (timeDivision.isEmpty()) return ""

        val result = addSubtractCalculate(timeDivision)
        return result.toString()
    }

    private fun addSubtractCalculate(passedList: MutableList<Any>): Any {
        var result = passedList[0] as Float

        for (i in passedList.indices) {
            if (passedList[i] is Char && i != passedList.lastIndex) {
                val operator = passedList[i]
                val nextDigit = passedList[i + 1] as Float
                if (operator == '+')
                    result += nextDigit
                if (operator == '-')
                    result -= nextDigit
            }
        }
        return result
    }

    private fun timesDivisionCalculate(passedList: MutableList<Any>): MutableList<Any> {
        var List = passedList
        while (List.contains('x') || List.contains('/')) {
            List = calcTimeDiv(List)
        }
        return List
    }

    private fun calcTimeDiv(passedList: MutableList<Any>): MutableList<Any> {
        val newList = mutableListOf<Any>()

        var restartIndex = passedList.size
        for (i in passedList.indices) {
            if (passedList[i] is Char && 1 != passedList.lastIndex && i < restartIndex) {
                val operator = passedList[i]
                val preDigit = passedList[i - 1] as Float
                val nextDigit = passedList[i + 1] as Float
                when (operator) {
                    'x' -> {
                        newList.add(preDigit * nextDigit)
                        restartIndex = i + 1
                    }
                    '/' -> {
                        newList.add(preDigit / nextDigit)
                        restartIndex = i + 1
                    }
                    else -> {
                        newList.add(preDigit)
                        newList.add(operator)
                    }
                }
            }
            if (i > restartIndex) {
                newList.add(passedList[i])
            }
        }
        return newList

    }

    private fun digitsOperator(): MutableList<Any> {
        val list = mutableListOf<Any>()
        var currentDigit = ""
        for (character in working_TV.text) {
            if (character.isDigit() || character == '.')
                currentDigit += character
            else {
                list.add(currentDigit.toFloat())
                currentDigit = ""
                list.add(character)
            }
        }
        if (currentDigit != "")
            list.add(currentDigit.toFloat())
        return list
    }
}