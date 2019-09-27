package com.mat.todos.controller;


import com.mat.todos.enums.TodoStatus;
import com.mat.todos.form.TodoCreateForm;
import com.mat.todos.form.TodoUpdateForm;
import com.mat.todos.model.Todo;
import com.mat.todos.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.xml.ws.Response;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequestMapping("api/todos")
@RestController
public class TodoController {



    @Autowired
    private TodoService todoService;

    @PostMapping("/todo")
    public ResponseEntity<Todo> createTodo(@RequestBody @Valid TodoCreateForm form) {

        Todo todo = todoService.createTodo(form.getName(), TodoStatus.ACTIVE);

        return ResponseEntity.ok(todo);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Todo>> listAll() {
        return ResponseEntity.ok(todoService.listAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Todo>> getTodo(@PathVariable("id") String id) {
        Optional<Todo> todo = todoService.getTodo(UUID.fromString(id));
        if (todo == null) {
            return ResponseEntity.of(Optional.empty());
        } else {
            return ResponseEntity.ok(todoService.getTodo(UUID.fromString(id)));
        }

    }

    @PutMapping("/{id}")
    public ResponseEntity<Todo> updateTodo(@PathVariable("id") String id, @RequestBody @Valid TodoUpdateForm form) {
        Todo todo = todoService.updateTodo(UUID.fromString(id), form.getName(), form.getStatus());
        if (todo == null) {
          return ResponseEntity.of(Optional.empty());
        } else {
            return ResponseEntity.ok(todoService.updateTodo(UUID.fromString(id), form.getName(), form.getStatus()));
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteTodo(@PathVariable("id") String id) {
        return ResponseEntity.ok(todoService.deleteTodo(UUID.fromString(id)));
    }

    @GetMapping("/active")
    public ResponseEntity<List<Todo>> listActive() {
        return ResponseEntity.ok(todoService.listActive());
    }

    @GetMapping("/completed")
    public ResponseEntity<List<Todo>> listCompleted() {
        return ResponseEntity.ok(todoService.listCompleted());
    }




}
