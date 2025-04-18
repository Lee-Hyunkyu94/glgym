package glgym;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class IndexController {

  @GetMapping(value = "/")
  public HashMap<String,String> test() {
    HashMap<String,String> test = new HashMap<>();
    test.put("test","2.5.5");
    test.put("test1","2.5.5");
    return test;
  }

  @GetMapping("hello-mvc")
  public String helloMvc(@RequestParam(value = "name", required = false) String name, Model model) {
    model.addAttribute("name", name);
    return "hello-template";
  }
}
