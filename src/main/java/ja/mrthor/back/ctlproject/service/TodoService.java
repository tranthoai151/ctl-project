package ja.mrthor.back.ctlproject.service;

import ja.mrthor.back.ctlproject.entity.Todo;

import java.util.List;

public interface TodoService {
    List<Todo> getAllTodos (String username);
    Todo findById(long id);
    Todo deleteTodo(long id);
}
