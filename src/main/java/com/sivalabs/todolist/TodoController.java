package com.sivalabs.todolist;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
class TodoController {
    private final TodoRepository repo;

    public TodoController(TodoRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    List<Todo> getAll() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    Todo getById(@PathVariable Long id) {
        return repo.findById(id).orElseThrow();
    }

    @PostMapping
    Todo create(@RequestBody Todo todo) {
        todo.setId(null);
        return repo.save(todo);
    }

    @PutMapping("/{id}")
    Todo update(@PathVariable Long id, @RequestBody Todo todo) {
        Todo entity = repo.findById(id).orElseThrow();
        entity.setContent(todo.getContent());
        return repo.save(entity);
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable Long id) {
        repo.deleteById(id);
    }
}
