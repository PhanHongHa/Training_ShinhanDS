package com.example.demoRESTFulAPI.controller;

import com.example.demoRESTFulAPI.entity.Todo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/")
public class DemoController {
    private List<Todo> todoList = new ArrayList<>();

    @PostConstruct
    public void init(){
        todoList.add(null);
    }
    @GetMapping(value ="/")
    public List<Todo> getTodolist(){
        return todoList;
    }

    @PostMapping(value = "/todo")
    public List<Todo> addTodo(@RequestBody Todo todo){
        todoList.add(todo);
        return todoList;
    }

    @PutMapping(value = "/todo/{todoId}")
    public Todo editTodo(@PathVariable(name ="todoId") Integer todoId, @RequestBody Todo todo){
        todoList.set(todoId, todo);
        return todo;
    }

    @DeleteMapping(value = "/todo/{todoId}")
    public String deleteTodo(@PathVariable(name ="todoId") Integer todoId){
        todoList.remove(todoId.intValue());
        return "deleted";
    }
}
