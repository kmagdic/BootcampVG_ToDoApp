package bootcamp.todoapp.ToDoApp.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import java.util.Random;

@Data
@Entity
@Table(name = "app_user")
public class AppUser {
    @Id
    @GeneratedValue
    private int id;

    private String firstName;
    private String lastName;

    private String email;
    private String password;

    // ovo difinira u kojem je formatu datum kad se dobiva iz forme
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthDate;


    private Boolean archived = false;

    public AppUser() {
        password = generatePin();
    }

    private String generatePin() {
        Random random = new Random();
        int lower = 1000;
        int upper = 9999;
        String pin = String.valueOf(random.nextInt(upper - lower + 1) + lower);
        return pin;
    }


}
