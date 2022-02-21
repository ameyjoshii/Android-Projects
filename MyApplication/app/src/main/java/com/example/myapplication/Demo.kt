package com.example.myapplication

fun fib(){                                               //Fibbonacci Series
    println("Enter the number:")
    var n = Integer.valueOf(readLine())
    var a = 0
    var b = 1
    print("First $n elements:")

    for(i in 1..n){
        print(" $a ")
        val sum = a + b
        a = b
        b = sum
    }
}

fun prime(){                                              //Prime numbers
    println("Enter the number:")
    var i = 2
    var n = Integer.valueOf(readLine())
    print("Prime numbers till $n :")
    while(i<n){
        var flag = false

        for(j in 2..i / 2){
            if(i%j == 0){
                flag = true
                break
            }
        }
        if(!flag)
            print(" $i ")
        ++i
    }
}

fun palindrome(){                                       //Palindrome
    println("Enter the number:")
    var n = Integer.valueOf(readLine())
    var str = n.toString()
    if(str == str.reversed())
        println("Palindrome")
    else
        println("Not Palindrome")
}

fun fact(){                                           //Factorial
    println("Enter the number:")
    var n = Integer.valueOf(readLine())
    var fact = 1
    for(i in n downTo 1){
        fact = fact * i
    }
    println("Factorial of $n is: $fact")
}

fun arm(){                                          //Armstrong Number
    println("Enter the number:")
    var n = Integer.valueOf(readLine())
    var n1: Int
    var rem: Int
    var res = 0
    var k = 0

    n1 = n
    while(n1 != 0){
        n1 = n1/10
        ++k
    }

    n1 = n
    while(n1 != 0){
        rem = n1 % 10
        res = res + Math.pow(rem.toDouble(), k.toDouble()).toInt()
        n1 = n1 / 10
    }

    if(res == n)
        print("Armstrong Number")
    else
        print("Not Armstrong Number")

}

fun sod(){                                          //Sum of Digits
    println("Enter the number:")
    var n = Integer.valueOf(readLine())
    var temp = 0
    var sum = 0
    while(n != 0){
        temp = n % 10
        sum = sum + temp
        n = n / 10
    }
    println("Sum of Digits: $sum")
}

fun rev(){                                          //reversing the number
    println("Enter the number:")
    var n = Integer.valueOf(readLine())
    var str = n.toString()
    str = str.reversed()
    print("Reversed Number is: $str")
}

fun swap(){                                         //swapping two numbers
    println("Enter the 1st number:")
    println("Enter the 2nd number:")
    var n1 = Integer.valueOf(readLine())
    var n2 = Integer.valueOf(readLine())

    n1 = n1 + n2
    n2 = n1 - n2
    n1 = n1 - n2

    println("Swapped numbers: $n1, $n2")
}

fun main(){
    println("MENU")
    println("1. Fibbonacci \n2. Prime Number \n3. Palindrome \n4. Factorial \n5. Armstrong Number \n6. Sum Of Digits \n7. Reverse \n8. Swap")
    println("Enter a choice:")
    var choice = Integer.valueOf(readLine())
    when(choice){
        1-> fib()
        2-> prime()
        3-> palindrome()
        4-> fact()
        5-> arm()
        6-> sod()
        7-> rev()
        8-> swap()
        else->{
            println("End")
        }
    }


    //val arr = arrayOf(10)
    /*for(i in arr.indices){
        value = Integer.valueOf(readLine())
    }*/

//    val arr= Array<Int>(5){ readLine()!!.toInt()}
//
//    for (item in arr)
//        println(item)
//
////    println("Hello World!!")
//
//    val mutableMap = mutableMapOf<Int,String>(1 to "Amey",2 to "Shivam",3 to "Manav")
//    mutableMap.put(4,"Mrunali")
//
//    for(item in mutableMap)
//        println(item.value)
//

}