package com.example.caculatormvp.Presenter

class PresenterClass (private val mainview: PresenterInterface.View): PresenterInterface.Presenter {
    var op=true
    var operator =""
    override fun onButtonClick(number: String) {
        mainview.show(number)
    }

    override fun forCalculation(number: String) {

//        op=false
        operator=number
        mainview.show(number)

    }

    override fun onEqual(value: String) {
        if (Operator(value).size>1){
            var num1=Operator(value).first().toDouble()
            var num2=Operator(value).last().toInt()
            when(operator){
                "+" -> mainview.result(Operator(value).first().toDouble() + Operator(value).last().toDouble())
                "-" ->mainview.result(num1-num2)
                "*" -> mainview.result(num1 * num2)
                else ->if (num2 != 0){
                    mainview.result(num1/num2)
                }else{
                    mainview.onError()
                }
            }
        }
    }

    override fun onDelte(value: String){
        mainview.onDelete(value.dropLast(1))
    }


    fun Operator(number:String):List<String>{
        return when(operator){
            "+" -> number.split("+")
            "_" -> number.split("-")
            "*" ->number.split("*")
            else -> number.split("/")
        }
    }
}


