package com.example.blogg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/index")
    public String login(Model model, users user, HttpServletRequest request) {
        users checked = userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
        if (checked != null) {
            HttpSession session = request.getSession(true);
            session.setAttribute("loggedin", true);
            model.addAttribute("loggedin", true);
            return "index";
        } else {
            model.addAttribute("loggedin", false);
            return "index";
        }
    }


    @GetMapping("/index")
    public String getUsers(Model model, HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        if (session.getAttribute("loggedin") != null) {
            model.addAttribute("loggedin", true);
            return "index";
        } else {
            model.addAttribute("loggedin", false);
            return "index";
        }
    }
}

