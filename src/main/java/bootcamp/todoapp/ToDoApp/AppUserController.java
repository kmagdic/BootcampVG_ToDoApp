package bootcamp.todoapp.ToDoApp;

import bootcamp.todoapp.ToDoApp.model.AppUser;
import bootcamp.todoapp.ToDoApp.model.AppUserRespositry;
import bootcamp.todoapp.ToDoApp.model.TodoItem;
import bootcamp.todoapp.ToDoApp.model.TodoRespositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("users") // ovo definira prefix
public class AppUserController {

    @Autowired
    AppUserRespositry repository;

    @GetMapping("/list")
    public String list(Model model) {
        System.out.println("Listing all users ...");

        model.addAttribute("users", repository.findAll());
        model.addAttribute("user", new AppUser()); // empty user for adding new

        return "app_users";
    }

    @GetMapping("/add")
    public String add(AppUser userForm) {
        System.out.println("Adding new user ...");

        repository.save(userForm);
        return "redirect:/users/list";
    }


    @GetMapping("/delete")
    public String delete(int id) {
        System.out.println("Delete id ... " + id);
        repository.deleteById(id);

        return "redirect:/users/list";
    }
}
