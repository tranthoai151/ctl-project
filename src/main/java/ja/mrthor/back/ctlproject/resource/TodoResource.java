package ja.mrthor.back.ctlproject.resource;

import ja.mrthor.back.ctlproject.entity.Todo;
import ja.mrthor.back.ctlproject.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class TodoResource {
    @Autowired
    private TodoService todoService;

    @RequestMapping("/users/{username}/todos")
    public List<Todo> getAllTodos(@PathVariable  String username){
        return todoService.getAllTodos(username);
    }

    @GetMapping("/users/{username}/todos/{id}")
    public Todo getTodoById(@PathVariable String username, @PathVariable long id){
        return todoService.findById(id);
    }

    @DeleteMapping("/users/{username}/todos/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable String username, @PathVariable long id){
        Todo todo = todoService.deleteTodo(id);
        if (todo != null){
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }
}
