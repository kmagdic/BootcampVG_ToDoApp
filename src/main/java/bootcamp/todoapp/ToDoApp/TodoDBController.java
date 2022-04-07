package bootcamp.todoapp.ToDoApp;

import bootcamp.todoapp.ToDoApp.model.TodoItem;
import bootcamp.todoapp.ToDoApp.model.TodoRespositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.Map;

@Controller
public class TodoDBController {

    // autowired omogućava za
    @Autowired
    TodoRespositry repository;

    @GetMapping("/list")
    public String list(Model model) {
        System.out.println("Listing all ...");

        model.addAttribute("todos", repository.findAll());
        return "todo";
    }

    @GetMapping("/add")
    public String add(String text) {
        System.out.println("Adding new ...");

        repository.save(new TodoItem(text));
        return "redirect:/list";
    }


    @GetMapping("/delete")
    public String delete(int id) {
        System.out.println("Delete id ... " + id);
        repository.deleteById(id);

        return "redirect:/list";
    }

    @GetMapping("/listTodosForUser")
    public String listTodosForUser(int userId, Model model) {
        System.out.println("List all todo id ... " + userId);
        model.addAttribute("todos", repository.findAllByAppUserId(userId));

        return "todo";
    }

}
