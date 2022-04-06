package bootcamp.todoapp.ToDoApp.model;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TodoRespositry extends CrudRepository<TodoItem, Integer> {

    List<TodoItem> findAll();
}
