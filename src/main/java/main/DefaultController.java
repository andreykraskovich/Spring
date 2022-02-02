package main;

import models.ToDo;
import models.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;


@RestController
public class DefaultController {

    @Autowired
    private ToDoRepository toDoRepository;
    @GetMapping("/")
    public String index(Model model)
    {
        Iterable<ToDo> toDoIterable = toDoRepository.findAll();
        ArrayList<ToDo> todos = new ArrayList<>();
        for (ToDo todo : toDoIterable){
            todos.add(todo);
        }
        model.addAttribute("todos", todos);
        model.addAttribute("todoCount", todos.size());
        return "index";
    }
}
