package com.example.todo.repository

import com.example.todo.database.Todo
import com.example.todo.database.TodoDatabase
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.lang.Exception
import java.time.LocalDateTime

@Service
class TodoRepositoryImpl : TodoRepository {

    //todoDatabase에 있는init메서드의 데이터 베이스 객체가 자동으로 주입이 됨
    @Autowired
    lateinit var todoDatabase: TodoDatabase

    override fun save(todo: Todo): Todo? {

        //1.index가 있는지 없는지 판단
        todo.index?.let{ index->
            //update
            return findOne(index)?.apply {
                this.title = todo.title
                this.description = todo.description
                this.schedule = todo.schedule
                this.updateAt = LocalDateTime.now()
            }
        }?: run{
            //todoDatabase에 마지막 인덱스번호를 가져와서 추가되는 todo에 인덱스 추가
            //val index = todoDatabase.index++
            //todo.index = index
            //todoDatabase.todoList.add(todo)

            //=>하단은 코틀린스럽게 변환시킨것
            return todo.apply {
                this.index = ++todoDatabase.index
                this.updateAt = LocalDateTime.now()
                this.createAt = LocalDateTime.now()
            }.run {
                todoDatabase.todoList.add(todo)
                this
            }
        }
    }

    override fun saveAll(todoList: MutableList<Todo>): Boolean {
        return try{
            todoList.forEach{
                save(it)
            }
            true
        }catch(e: Exception){
            false
        }
    }

//    override fun update(todo: Todo): Todo {
//        //jpa
//        //save는 db에 index가 있는가 없는가를 기준으로 판단
//
//        TODO("Not yet implemented")
//    }

    override fun delete(index: Int): Boolean {
        //todo를 인덱스 값으로 가져와서 해강 값이 null이 아닌경우에는 remove를 실행 시키도 null일 경우에는 false를 반환
        return findOne(index)?.let{
            todoDatabase.todoList.remove(it)
            true
        }?: kotlin.run{
            false
        }
    }

    override fun findOne(index: Int): Todo? {
        return todoDatabase.todoList.first { it.index == index }
    }

    override fun findAll(): MutableList<Todo> {
        TODO("Not yet implemented")
    }

}