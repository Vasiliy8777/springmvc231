package web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.dao.Dao;
import web.model.User;


@Controller
@RequestMapping("/users")
public class UserController {
    private final Dao dao;

    @Autowired
    public UserController(Dao dao) {
        this.dao = dao;
    }

    @GetMapping("")
    public String getAllUsers(Model model) {
        model.addAttribute("users", dao.getAllUsers());
        return "index";
    }

    @GetMapping("/new")
    public String newPerson(Model model) {
        model.addAttribute("user", new User());
        return"new";
    }

    @PostMapping("/create")
    public String add(@ModelAttribute User user) {
        dao.addUser(user);
        return "redirect:/users";

    }

    @GetMapping("/id")
    public String getUser(@RequestParam (value = "id", required = false) int id, Model model) {
        model.addAttribute("user", dao.getUserById(id));
        return "show";
    }

    @GetMapping("/update")
    public String updateUser(@RequestParam (value = "id", required = false) int id, Model model) {
        model.addAttribute(dao.getUserById(id));
        return "edituser";
    }

    @PostMapping("/edit")
    public String update(User user) {
        dao.updateUser(user);
        return "redirect:/users";
    }
    @PostMapping("/delete")
    public String deleteUser(@RequestParam (value = "id", required = false) int id) {
        dao.deleteUser(id);
        return "redirect:/users";
    }
}

