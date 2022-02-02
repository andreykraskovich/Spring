package main;

import models.ToDo;
import models.ToDoList;
import models.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class ToDoController {
    @Autowired
    private ToDoRepository toDoRepository;

    @GetMapping("/todos/")
    public  List<ToDo> list()
    {
        Iterable<ToDo> allTodos = toDoRepository.findAll();
      return new ArrayList<>((Collection<? extends ToDo>) allTodos);
    }
    @PostMapping("/todos/")
    public  int add(ToDo toDo)
    {
        ToDo toDo1 = toDoRepository.save(toDo);
        return toDo1.getId();
    }
    @DeleteMapping("/todos/")
    public  boolean deleteList()
    {
        toDoRepository.deleteAll();
        return true;
    }
    @DeleteMapping("/todos/{id}")
    public boolean deleteToDo(int id){
        toDoRepository.deleteById(id);
        return true;
    }
    @PutMapping("/todos/{id}")
    public boolean edit(int id, ToDo toDo){
        toDoRepository.deleteById(id);
        ToDo newToDo = toDoRepository.save(toDo);
        return true;
    }
    @GetMapping("/todos/{id}")
    public ResponseEntity getTodo(@PathVariable int id){
        Optional<ToDo> toDo = toDoRepository.findById(id);
        if(!toDo.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return new ResponseEntity(toDo.get(), HttpStatus.OK);
    }
}
