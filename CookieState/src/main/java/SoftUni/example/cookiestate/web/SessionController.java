package SoftUni.example.cookiestate.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class SessionController {

    private static final String SESSION_ATTRIBUTE = "lang";
    private static final String DEFAULT_LANGUAGE = "English";

    @GetMapping("/session")
    public String session(HttpSession session, Model model) {
        Object sessionLang = session.getAttribute(SESSION_ATTRIBUTE);
        model.addAttribute("lang", sessionLang != null ? SESSION_ATTRIBUTE : DEFAULT_LANGUAGE);
        return "/session";
    }


    @PostMapping("/session")
    public String session(HttpSession session, @RequestParam("language") String language) {

        session.setAttribute("lang", language);
        return "redirect:/session";
    }
}
