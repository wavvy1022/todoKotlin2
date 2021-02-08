package com.example.todo.database


//코틀린은 파일명과 클래스 명이 일치하지 않아도 되며 하나의 파일 안에 여러 클레스가 들어가도 됌

//코틀린 생성자는 자바와 같이 따로 만드는 것이 아닌 class옆에 constructor를 작성하면 됨(생략가능)
//생성자 옆 파라미터를 작성할때 값을 할당하면 생성자를 호출 할때 값을 넣지 않더라도 해당 값이 디폴트값으로 들어감
class Human constructor(name:String = "Anonymous"){

    val name = name
    fun eatingCake(){
        println("eat cake")
    }
}

fun main(){
    val human = Human("wavvy")

    val stranger = Human()
    human.eatingCake()

    println("this human name is ${stranger.name}")

}



