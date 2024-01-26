package web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import web.dao.Dao;
import web.model.User;
import web.service.UserService;

import javax.validation.Valid;


@Controller
@RequestMapping("/users")
public class UserController {
private final UserService userService;

@Autowired
public UserController(UserService userService) {
    this.userService = userService;
}

@GetMapping("")
public String getAllUsers(Model model) {
    model.addAttribute("users", userService.getAllUsers());
    return "index";
}

@GetMapping("/new")
public String newPerson(Model model) {
    model.addAttribute("user", new User());
    return "new";
}

@PostMapping("/create")
public String add(@ModelAttribute User user) {
    userService.addUser(user);
    return "redirect:/users";

}

@GetMapping("/id")
public String getUser(@RequestParam(value = "id", required = false) int id, Model model) {
    model.addAttribute("user", userService.getUserById(id));
    return "show";
}

@GetMapping("/update")
public String updateUser(@RequestParam(value = "id", required = false) int id, Model model) {
    model.addAttribute(userService.getUserById(id));
    return "edituser";
}

@PostMapping("/edit")
public String update(@Valid User user, BindingResult bindingResult) {
    if (bindingResult.hasErrors()) {
        return "edit";
    } else {
        userService.updateUser(user);
        return "redirect:/users";
    }
}

@PostMapping("/delete")
public String deleteUser(@RequestParam(value = "id", required = false) int id) {
    userService.deleteUser(id);
    return "redirect:/users";
}
}

