package web.controllers;

import dao.UserDao;
import model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UserController {
    private final UserDao userDao =new UserDao();

    @GetMapping("")
    public String index(Model model){
        model.addAttribute("users",userDao.index());
        return "users/index";
    }
    @GetMapping("/find")
    public String show(@RequestParam(value = "id", required = false) int id, Model model) {
        model.addAttribute("user", userDao.show(id));
        return "users/show";
    }
    @GetMapping("/new")
    public String newPerson(@ModelAttribute("user") User person) {
        return"users/new";
    }

    @PostMapping("/create")
    public String create(@RequestParam String name, @RequestParam String sureName) {
        userDao.save(name,sureName);
        return "redirect:/users";
    }
    @GetMapping("/user_edit")
    public String edit(Model model, @RequestParam int id) {
        model.addAttribute("user", userDao.show(id));
        return "users/edit";
    }

    @PostMapping("/post_edit")
    public String update(@ModelAttribute("user") User user, @RequestParam int id) {
        userDao.update(id, user);
        return "redirect:/users";
    }
    @PostMapping("/delete")
    public String delete(@RequestParam int id) {
        userDao.delete(id);
        return "redirect:/users";
    }
}
