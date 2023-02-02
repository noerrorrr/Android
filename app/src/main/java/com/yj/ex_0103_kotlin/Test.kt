package com.yj.ex_0103_kotlin

class Test() {

    fun result( num1:Int, num2:Int, op:String) : Int {

        var res:Int = 0

        try {

            when( op ){
                "+" -> { res = num1 + num2 }
                "-" -> { res = num1 - num2 }
                "*" -> { res = num1 * num2 }
                "/" -> { res = num1 / num2 }
            }

        }catch (e:Exception){

        }

        return res
    }//result

}













