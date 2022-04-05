package bootcamp.todoapp.ToDoApp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CalcController {
    List<String> historyList = new ArrayList<>();

    // http://localhost:8080/sum?a=10&b=5

    @GetMapping("/sum")
    public void sum123(@RequestParam int a, @RequestParam int b, ServletResponse response) throws IOException {
        int r = a + b;

        response.getWriter().println("Result is " + r);
    }



    @GetMapping("/c")
    public String c(Model model) {
        model.addAttribute("historyList", historyList);
        model.addAttribute("res", 0);
        return "calc";
    }

    @GetMapping("/calculate")
    public String calculate (@RequestParam int a,
                             @RequestParam String operation,
                             @RequestParam int b,
                             Model model)  {

        double result = 0;

        switch (operation) {
            case "+":
                result = a + b;
                break;
            case "-":
                result = a - b;
                break;
            case "/":
                result = a / b;
                break;
            case "*":
                result = a * b;
                break;
        }
        historyList.add(a + " " + operation + " " + b + " = " + result);

        model.addAttribute("historyList", historyList);
        model.addAttribute("res", result);

        return "calc";
    }

}
