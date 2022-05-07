package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import web.model.User;
import web.service.UserService;

@Controller
public class CreateUserController {

    final UserService userService;

    public CreateUserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/allUser/new")
    public String newUser(@ModelAttribute("user") User user){
        return "users/newUser";
    }

    @PostMapping()
    public String creaeUser(@ModelAttribute("user") User user){
    userService.saveUser(user);
    return "redirect:/allUser";
    }
}
