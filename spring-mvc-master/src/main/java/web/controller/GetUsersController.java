package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import web.service.UserService;

@Controller
public class GetUsersController {

    final UserService userService;

    public GetUsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/allUser")
    public String getTableCarForNumber(Model model) {
        model.addAttribute("users",userService.getListUsers());
        return "users/allUser";
    }

    @GetMapping("/allUser/{id}")
    public String showUser(@PathVariable("id") int id, Model model) {
        model.addAttribute("user",userService.getUserById(id));
        return "users/getUser";
    }
}