package com.mat.todos.service;


import com.mat.todos.enums.TodoStatus;
import com.mat.todos.model.Todo;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TodoService {

    Todo createTodo(String name, TodoStatus status);

    List<Todo> listAll();

    Optional<Todo> getTodo(UUID id);

    Todo updateTodo(UUID id, String name, TodoStatus status);

    boolean deleteTodo(UUID id);

    List<Todo> listActive();

    List<Todo> listCompleted();

}
