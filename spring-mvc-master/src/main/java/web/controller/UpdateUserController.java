package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import web.model.User;
import web.service.UserService;

@Controller
public class UpdateUserController {

        final UserService userService;

        public UpdateUserController(UserService userService) {
            this.userService = userService;
        }

        @GetMapping("/allUser/{id}/editUser")
        public String editUser(Model model, @PathVariable("id") int id){
            model.addAttribute("user",userService.getUserById(id));
            return "users/editUser";
        }

        @PatchMapping("/allUser/{id}")
        public String updateUserById(@ModelAttribute("user") User user,@PathVariable("id") int id){
            userService.updateUserById(id,user);
            return "redirect:/allUser";
        }
    }
