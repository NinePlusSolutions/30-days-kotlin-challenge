package com.example.caculatormvp.Presenter

interface PresenterInterface {
    interface View{
        fun show(number: String)
        fun result(result:Double)
        fun onError()
        fun onDelete(value: String)


    }
    interface Presenter{
        fun onButtonClick(number: String)
        fun forCalculation(value: String)
        fun onEqual(value: String)
        fun onDelte(value: String)

    }



}