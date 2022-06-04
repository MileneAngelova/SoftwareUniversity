package softuni.hello.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

    @GetMapping("/hello")
    public String hello(Model model) {

        model.addAttribute("num", 3);
        return "hello";
    }

//    @GetMapping("/hello")
//    public String hello(Model model, @RequestParam("num") Integer num) {
//
//        model.addAttribute("num", num);
//        return "hello";
//    }
}
