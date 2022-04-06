package bootcamp.todoapp.ToDoApp.model;

import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface AppUserRespositry extends CrudRepository<AppUser, Integer> {

    List<AppUser> findAll();


}
