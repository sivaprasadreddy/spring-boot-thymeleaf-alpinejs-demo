package com.sivalabs.todolist;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class PageController {

    @GetMapping("/todos/{id}")
    String getById(@PathVariable Long id, Model model) {
        model.addAttribute("todoId", id);
        return "todo";
    }

    @GetMapping("/todos/add")
    String addTodoPage() {
        return "add-todo";
    }
}
