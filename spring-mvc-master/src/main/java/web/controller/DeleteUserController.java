package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import web.service.UserService;

    @Controller
    public class DeleteUserController {

        final UserService userService;

        public DeleteUserController(UserService userService) {
            this.userService = userService;
        }

        @DeleteMapping("/allUser/{id}")
        public String deleteUser(@PathVariable("id") int id){
        userService.deleteUserById(id);
            return "redirect:/allUser";
        }
}
