package com.example.todo.database


//코틀린은 파일명과 클래스 명이 일치하지 않아도 되며 하나의 파일 안에 여러 클레스가 들어가도 됌

//코틀린 생성자는 자바와 같이 따로 만드는 것이 아닌 class옆에 constructor를 작성하면 됨(생략가능)
//생성자 옆 파라미터를 작성할때 값을 할당하면 생성자를 호출 할때 값을 넣지 않더라도 해당 값이 디폴트값으로 들어감
open class Human(val name : String = "Anonymous"){

    //this라는 예약어를 통해 부생성자는 주생성자의 위임을 받아야함
    constructor(name : String, age : Int) : this(name){
        println("my name is ${name}, ${age} years old")
    }

    //코드 블록을 넣기 위한것 처음 인스턴스를 생성할때 어떤 동작을 하고싶은지에 대해서 작성
    init{
        println("New human has been born")
    }

    fun eatingCake(){
        println("eat cake")
    }

    open fun singASong(){
        println("lalala")
    }
}

//human클래스 상속
class Korean : Human(){
    override fun singASong(){
        super.singASong()
        println("라라라")
        println("my name is :${name}")
    }
}

fun main(){
//    val human = Human("wavvy")
//
//    val stranger = Human()
//
//    human.eatingCake()
//    println("this human name is ${human.name}")
//    println("this human name is ${stranger.name}")

    val mom = Human("kuri",52)

    println("this human name is ${mom.name}")

}



