package com.mat.todos.form;

import com.sun.istack.internal.NotNull;

import javax.validation.constraints.NotBlank;

public class TodoCreateForm {

    @NotNull
    @NotBlank(message = "must not be empty")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
