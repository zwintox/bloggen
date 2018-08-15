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
    private int userId;
    @PostMapping("/index")
    public String login(posts post, Model model, users user, HttpServletRequest request) {
        users checked = userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
        this.userId = checked.getId();
        System.out.println(checked.getUsername());
        if (checked != null) {
            HttpSession session = request.getSession(true);
            session.setAttribute("loggedin", true);
            model.addAttribute("loggedin", true);
            return "bloggposts";
        } else {
            model.addAttribute("notloggedin", true);
            return "index";
        }
    }


    @GetMapping("/index")
    public String getUsers(posts post, users user, Model model, HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        if (session.getAttribute("loggedin") != null) {
            model.addAttribute("loggedin", true);
            return "bloggposts";
        } else {
            model.addAttribute("notloggedin", true);
            return "index";
        }
    }

    public int getUserId() {
        return this.userId;
    }
}

