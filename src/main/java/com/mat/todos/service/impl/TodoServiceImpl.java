package com.mat.todos.service.impl;

import com.mat.todos.enums.TodoStatus;
import com.mat.todos.model.Todo;
import com.mat.todos.service.TodoService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class TodoServiceImpl implements TodoService {

    List<Todo> todoList = new ArrayList<>();

    @Override
    public Todo createTodo(String name, TodoStatus status) {
        Todo todo = new Todo(name, status);
        todo.setId(UUID.randomUUID());
        todoList.add(todo);
        return todo;
    }

    @Override
    public List<Todo> listAll() {
        return todoList;
    }

    @Override
    public Optional<Todo> getTodo(UUID id) {
        return todoList.stream().filter(todo -> todo.getId().equals(id))
                .findFirst();
    }

    @Override
    public Todo updateTodo(UUID id, String name, TodoStatus status) {

        Todo foundToDo = null;
        for (Todo todo : todoList) {
            if (todo.getId().equals(id)) {
                todo.setName(name);
                todo.setStatus(status);

                foundToDo = todo;
                break;
            }
        }
        return foundToDo;
    }

    @Override
    public boolean deleteTodo(UUID id) {
        boolean deleted = false;
        for (Todo todo : todoList) {
            if (todo.getId().equals(id)) {
                todoList.remove(todo);
                deleted = true;
            }
        }
        return deleted;
    }

    @Override
    public List<Todo> listActive() {
        return todoList.stream().filter(todo -> todo.getStatus() == TodoStatus.ACTIVE)
                .collect(Collectors.toList());

    }

    @Override
    public List<Todo> listCompleted() {
        return todoList.stream()
                .filter(todo -> todo.getStatus() == TodoStatus.COMPLETED)
                .collect(Collectors.toList());
    }
}
