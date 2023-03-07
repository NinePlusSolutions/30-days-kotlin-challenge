package com.example.calculatormvp

interface MainContract {
    interface View {
        fun onButtonClicked(number: String)
        fun showResult(result: Int)
        fun showError()
        fun showDelete(number: String)



        // hien thi
    }

    interface Presenter {
        fun buttonClickNumber(number: String)
        fun operator(value: String)
        fun equal(number: String)
        fun delete(number: String)

    }// xu li ket qua
}// viet ham roi moi ke thua