package bootcamp.todoapp.ToDoApp;

import bootcamp.todoapp.ToDoApp.model.AppUser;
import bootcamp.todoapp.ToDoApp.model.AppUserRespositry;
import bootcamp.todoapp.ToDoApp.model.TodoItem;
import bootcamp.todoapp.ToDoApp.model.TodoRespositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class PatientController {

    // autowired omogućava automatsko spajanje (Spring)
    @Autowired
    TodoRespositry todoRespositry;

    @Autowired
    AppUserRespositry appUserRespositry;

    @GetMapping("/")
    public String showLogin() {
        return "login";
    }

    @GetMapping("/login")
    public String processLogin(String email, String password, HttpSession session, Model model) {
        AppUser user = appUserRespositry.findByEmail(email);
        if(user == null || !user.getPassword().equals(password)) {
            model.addAttribute("errorMsg", "Neispravan email ili lozinka");
            return "login";
        }

        session.setAttribute("user", user);
        return "redirect:/list";
    }

    @GetMapping("/logout")
    public String processLogin(HttpSession session) {
        session.removeAttribute("user");
        return "login";
    }

    @GetMapping("/list")
    public String list(Model model, HttpSession session) {
        AppUser user = (AppUser) session.getAttribute("user");

        if(user == null)
            return "redirect:/";

        System.out.println("Listing all ...");

        model.addAttribute("todos", todoRespositry.findAllByAppUserId(user.getId()));
        return "todo";
    }

    @GetMapping("/add")
    public String add(String text, HttpSession session) {
        AppUser user = (AppUser) session.getAttribute("user");

        if(user == null)
            return "redirect:/";

        System.out.println("Adding new ...");

        todoRespositry.save(new TodoItem(text, user));
        return "redirect:/list";
    }


    @GetMapping("/delete")
    public String delete(int id) {
        System.out.println("Delete id ... " + id);
        appUserRespositry.deleteById(id);

        return "redirect:/list";
    }

    @GetMapping("/listTodosForUser")
    public String listTodosForUser(int userId, Model model) {
        System.out.println("List all todo id ... " + userId);
        model.addAttribute("todos", todoRespositry.findAllByAppUserId(userId));

        return "todo";
    }

}
