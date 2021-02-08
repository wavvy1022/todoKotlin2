package com.example.todo.database

class Test {

    fun main(){
        testMethod()
        println(add(2,5))

        //3.String template
        val name = "wavvy"
        println("my name is {$name}I'm 30")
        println("my name is $name i'm 30")

        //4.조건식
        fun max(a:Int, b:Int):Int{
            if(a>b){
                return a
            }else{
                return b
            }
        }

        fun maxBy2(a:Int, b:Int) = if(a>b) a else b

        fun checkNum(score:Int){
            when(score){
                0 -> println("this is 0")
                1 -> println("this is 1")
                2,3 -> println("i don't know")
            }

            var b = when(score){
                1->1
                2->2
                else -> 3
            }

            when(score){
                in 90..100 -> println("you are genius")
                in 10..80 -> println("not bad")
                else -> println("okay")
            }
        }
    }

    //expression statement
    //expression => 값을 반환하는 경우
    //statement =>특정 명령을 실행하는경우


    //1.함수
    fun testMethod(){
        println("hello Kotlin")
    }

    fun add(a:Int, b:Int):Int{
        return a+b
    }

    //2.val var

    fun hi(){
        val a:Int = 10
        var b:Int = 9
        //a=100 val은 값을 다시 재할당 할 수 없다.
        b=20 //var는 값을 재할당 할 수 있다.
        var c = 100
        val d = 100
        var name = "wavvy"
    }

    //Array
    //List 1.List 2.MutableList

    fun array(){
        val array = arrayOf(1,2,3)
        val list = listOf(1,2,3)

        val arrayList = arrayListOf<Int>()
        arrayList.add(10)
        arrayList.add(20)
        //array 내부의 값이 변하더라도 arrayList를 참조하는 값은 변하지 않으므로 val로 변수 선언 가능
        //but 하단처럼 arrayList 다시 arraylist를 선언하게 되면 참조하는 값이 변하므로 var로 선언해야함

        //arrayList = arrayListOf()

        val mutableList = mutableListOf(1,2,3,4,5,6)
        array[0] = 3
        mutableList
        // list[0] = 2 값 수정 불가능 값을 읽어 오는것만 가능함

    }

    //6. for/ while
    fun forAndWhile(){
        val students = arrayListOf("joyce","james","jenny")
        for((index ,name)in students.withIndex()){
            println("${index}번째 학생 : ${name}")
        }

        var sum = 0
        for(i in 1..10){
            //1,2,3,4,5,6,7,8,9,10
            sum += i
        }
        for(i in 1..10 step 2){
            //1,3,5,7,9
            sum += i
        }
        for(i in 10 downTo 1){
            //10,9,8,7,6,5,4,3,2,1
            sum += i
        }
        for(i in 1 until 10){
            //1,2,3,4,5,6,7,8,9
            sum += i
        }

        println(sum)

        var index =0
        while(index<10){
            println("current Index ${index}")
            index++
        }

    }
    //7. Nullable/NonNull

    fun nullCheck(){
        //NPE : Null poinr exception
        var name : String = "joice"
        var nullName : String? = null //type뒤에 ?를 넣어주면 nullable타입이 됨 따라서 nullable타입을 만들기 위해서는 자료형을 작성해줘야함

        var nameInUpperCase = name.toUpperCase()
        var nullNameInUpperCase = nullName?.toUpperCase()//nullName이 null이 아닌경우에는 toUpperCase로 null일 경우에는 null을 반환하도록 함

        // ?: 엘비스연산자 => 특정 변수가 null이냐 아니냐에 따라 다른 연산을 하게끔 함
        val lastName :String? = null

        val fullName = name +" "+ (lastName?:"no lastName") //lastName이 있으면 해당 값을 출력하고 lastName이 null일 경우에는 no lastName을 출력한다.
        println(fullName)

    }


    //!! => nullable타입이긴 하지만 null이 아닐때 사용
    fun ignoreNulls(Str:String?){
        //val mNotNull : String = str mNotNull은 null이 아니지만 Str은 nullable이기때문에 오류 발생
        val mNotNull :String = Str!!// 해당 Str이 null이 확실히 아닐 경우에만 사용하도록! 왠만해선 지양해야함
        val upper:String = mNotNull.toUpperCase()

        val email : String? = "run2070@naver.com"
        //email이 null이 아니면 실행
        //let은 reciver 객체를 자신의 람다식 객체로 옮겨서 실행함
        //아래와 같이 email이 null이 아니면 let은 email을 블록 내부로 가져오게끔 해줌
        email?.let{
            //println("my email is ${email}")
           println("my email is"+it)
        }
    }

}