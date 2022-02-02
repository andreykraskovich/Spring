package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ToDoList {
    private static int currentId = 1;
    private static HashMap<Integer, ToDo> list = new HashMap<>();

    public List<ToDo> getAllTodos() {
        ArrayList<ToDo> toDosList = new ArrayList<ToDo>(list.values());
        return toDosList;
    }

    public int addToDo(ToDo toDo) {
        int id = currentId++;
        toDo.setId(id);
        list.put(id, toDo);
        return id;
    }

    public ToDo getToDo(int toDoId) {
        if (list.containsKey(toDoId)) {
            return list.get(toDoId);
        }
        return null;
    }

    public boolean deleteToDo(int toDoId)
    {
        if(list.containsKey(toDoId)){
            list.remove(toDoId);
            return true;
        }
        return false;
    }

    public boolean edit(int toDoId, ToDo toDo){
        if(list.containsKey(toDoId)){
            list.replace(toDoId, list.get(toDoId), toDo);
            return true;
        }
        return false;
    }

    public Map<Integer ,ToDo> deleteList(){
        list.clear();
        return list;
    }
}
