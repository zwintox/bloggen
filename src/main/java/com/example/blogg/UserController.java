package com.example.blogg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired UserRepositoryClass userRepositoryClass;


    @PostMapping("/index")
    public String login(posts post, Model model, users user, HttpServletRequest request) {
        users checked = userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
        System.out.println(checked.getUsername());
        if (checked != null) {
            HttpSession session = request.getSession(true);
            session.setAttribute("loggedin", true);
            model.addAttribute("loggedin", true);
            return "index";
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
            return "index";
        } else {
            model.addAttribute("notloggedin", true);
            return "index";
        }
    }
    @GetMapping("/createuser")
    public String create(users user) {
        return "createuser";
    }
    @PostMapping("/createuser")
    public String createNewUser (@RequestParam String username, @RequestParam String password) {
        userRepositoryClass.createUser(username, password);
        return "redirect:index";
    }




}

