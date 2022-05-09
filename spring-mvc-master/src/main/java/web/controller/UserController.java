package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import web.model.User;
import web.service.UserService;

@Controller
public class UserController {

    final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/allUser/new")
    public String newUser(@ModelAttribute("user") User user){
        return "newUser";
    }

    @PostMapping()
    public String creaeUser(@ModelAttribute("user") User user){
        userService.saveUser(user);
        return "redirect:/allUser";
    }

    @DeleteMapping("/allUser/{id}")
    public String deleteUser(@PathVariable("id") Long id){
        userService.deleteUserById(id);
        return "redirect:/allUser";
    }
    @GetMapping(value = "/allUser")
    public String getTableCarForNumber(Model model) {
        model.addAttribute("users",userService.getListUsers());
        return "allUser";
    }

    @GetMapping("/allUser/{id}")
    public String showUser(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user",userService.getUserById(id));
        return "getUser";
    }

    @GetMapping("/allUser/{id}/editUser")
    public String editUser(Model model, @PathVariable("id") Long id){
        model.addAttribute("user",userService.getUserById(id));
        return "editUser";
    }

    @PatchMapping("/allUser/{id}")
    public String updateUserById(@ModelAttribute("user") User user){
        userService.saveUser(user);
        return "redirect:/allUser";
    }
}
