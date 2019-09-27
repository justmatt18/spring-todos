package com.mat.todos.model;


import com.mat.todos.enums.TodoStatus;

import java.util.UUID;

import static com.mat.todos.enums.TodoStatus.ACTIVE;

public class Todo {

    private UUID id;
    private String name;
    private TodoStatus status;

    public Todo(String name, TodoStatus status) {
        this.name = name;
        this.status = status;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStatus(TodoStatus status) {
        this.status = status;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }


    public TodoStatus getStatus() {
        return status;
    }
}
