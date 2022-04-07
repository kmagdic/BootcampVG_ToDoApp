package bootcamp.todoapp.ToDoApp.model;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface TodoRespositry extends CrudRepository<TodoItem, Integer> {
    // metoda findAll - iz te metode Spring automatski kreirati
    List<TodoItem> findAll();
    List<TodoItem> findAllByAppUserId(int id);

}
