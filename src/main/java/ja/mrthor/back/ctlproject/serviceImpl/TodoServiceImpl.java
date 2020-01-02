package ja.mrthor.back.ctlproject.serviceImpl;

import ja.mrthor.back.ctlproject.entity.Todo;
import ja.mrthor.back.ctlproject.service.TodoService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TodoServiceImpl implements TodoService {
    private static  List<Todo> todos = new ArrayList<>();
    static {
        todos.add(new Todo(1, "thoaitran", "Learn Angular", new Date(), false));
        todos.add(new Todo(2, "thoaitran", "Learn Vuejs", new Date(), true));
        todos.add(new Todo(3, "thoaitran", "Learn Java beginner", new Date(), false));
        todos.add(new Todo(4, "thoaitran", "Learn english tutorial", new Date(), false));
        todos.add(new Todo(5, "thoaitran", "Learn BA", new Date(), false));
    }
    @Override
    public List<Todo> getAllTodos(String username) {
        return todos;
    }

    @Override
    public Todo findById(long id) {
        for (Todo todo: todos) {
            if(todo.getId() == id){
                return todo;
            }
        }
        return null;
    }

    @Override
    public Todo deleteTodo(long id) {
        Todo todo = findById(id);
        if (todo == null) return null;
        if(todos.remove(todo)){
            return todo;
        }
        return null;
    }

}
