package com.mat.todos.form;


import com.mat.todos.enums.TodoStatus;


public class TodoUpdateForm {


    private String name;
    private TodoStatus status;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TodoStatus getStatus() {
        return status;
    }

    public void setStatus(TodoStatus status) {
        this.status = status;
    }
}
