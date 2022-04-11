package bootcamp.todoapp.ToDoApp;

import bootcamp.todoapp.ToDoApp.model.AppUser;
import bootcamp.todoapp.ToDoApp.model.AppUserRespositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("users") // ovo definira prefix
public class DoctorController {

    @Autowired
    AppUserRespositry repository;

    @GetMapping("/list")
    public String list(Model model) {
        System.out.println("Listing all users ...");

        model.addAttribute("users", repository.findAllByArchivedIsFalse());
        model.addAttribute("user", new AppUser()); // empty user for adding new

        return "app_users";
    }

    @GetMapping("/save")
    public String save(AppUser userForm) {
        if(userForm.getId() == 0) {
            System.out.println("Adding new user ...");
        } else {
            System.out.println("Changing existing user ...");
        }


        repository.save(userForm);
        return "redirect:/users/list";
    }

    @GetMapping("/edit")
    public String showEdit(Integer userId, Model model) {
        System.out.println("Edit exising user ...");
        model.addAttribute("user", repository.findById(userId).get()); // empty user for adding new

        model.addAttribute("users", repository.findAllByArchivedIsFalse());
        return "app_users";
    }


    @GetMapping("/delete")
    public String delete(int id) {

        System.out.println("Delete id ... " + id);
        AppUser appUser = repository.findById(id).get();
        appUser.setArchived(true);
        repository.save(appUser);

        return "redirect:/users/list";
    }
}
