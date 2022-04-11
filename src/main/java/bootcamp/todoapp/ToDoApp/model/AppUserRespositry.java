package bootcamp.todoapp.ToDoApp.model;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface AppUserRespositry extends CrudRepository<AppUser, Integer> {

    List<AppUser> findAll();

    @Query("select a from AppUser a where a.archived = false")
    List<AppUser> findAllByArchivedIsFalse();


    @Query("select a from AppUser a where a.email = ?1")
    AppUser findByEmail(String email);


}
