package bootcamp.todoapp.ToDoApp.archive;

import bootcamp.todoapp.ToDoApp.model.TodoItem;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("mem")
public class TodoController {
    Map<Integer, TodoItem> todosMap = new HashMap<>();

    @GetMapping("/list")
    public String list(Model model) {
        System.out.println("Listing all ...");
        model.addAttribute("todos", todosMap.values());
        return "todo";
    }

    @GetMapping("/add")
    public String add(String text) {
        System.out.println("Adding new ...");

        int newId = todosMap.size() + 1;
        todosMap.put(newId, new TodoItem(newId, text));
        return "redirect:/list";
    }


    @GetMapping("/delete")
    public String delete(int id) {
        todosMap.remove(id);
        return "redirect:/list";
    }
}
