package bootcamp.todoapp.ToDoApp.model;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface TodoRespositry extends CrudRepository<TodoItem, Integer> {
    // metoda findAll - iz te metode Spring automatski kreirati implementaciju

    List<TodoItem> findAll();

    // metoda find All by AppUserId - traži sve TodoItem koji su od određenog korisnika

    List<TodoItem> findAllByAppUserId(int id);

}
