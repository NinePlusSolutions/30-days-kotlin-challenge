package com.example.calculatormvp

import android.util.Log

class MainPresenter(private val view: MainContract.View) : MainContract.Presenter {
    var operator = ""
    override fun buttonClickNumber(number: String) {
        view.onButtonClicked(number)
      //  Log.d("resultPre: ", number)

    }

    override fun operator(value: String) {
//        val data = value.split("+")
//        if (data.size > 1){
//            view.s    howResultAdd((data.first().toString().toInt() + data.last().toString().toInt()).toString())
//        }else{
//            view.showResultAdd(data.first().toString())
//        }

        operator = value
        view.onButtonClicked(value)


    }

    override fun equal(number: String) {
       if(checkO(number).size>1){
           val a = checkO(number).first().toInt()
           val b = checkO(number).last().toInt()
           when(operator){
               "+" -> view.showResult(a + b)
               "-" -> view.showResult(a - b)
               "X" -> view.showResult(a * b)
               else -> if(b ==0){
                   view.showError()
               }else view.showResult(a / b)
           }
       }
    }

    override fun delete(number: String) {
        view.showDelete(number.dropLast(1))
    }


    fun checkO(number: String):List<String>{
        return when(operator){
            "+" -> number.split("+")
            "-" -> number.split("-")
            "X" -> number.split("X")
            else -> number.split("/")
        }
    }

}