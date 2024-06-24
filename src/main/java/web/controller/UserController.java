package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

@Controller
public class UserController {

//    @Autowired
//    private UserService userService;
    private UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String showUsersTable(Model model){
        model.addAttribute("users", userService.getListOfUsers());
        return "users";
    }

    @GetMapping("/delete_user")
    public String deleteUser(@RequestParam long id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }

    @GetMapping("/add_user")
    public String addUser(@ModelAttribute User user) {
        userService.addUser(user);
        return "redirect:/users";
    }

//    @PostMapping("/edit_user")
//    public String editUser(@RequestParam long id, @RequestParam String firstName,
//                           @RequestParam String lastName, @RequestParam String email) {
//        User user = new User(firstName, lastName, email);
//        user.setId(id);
//        userService.editUser(user);
//        return "redirect:/users";
//    }
    @GetMapping("/edit_user")
    public String editUser(@RequestParam long id, @ModelAttribute User user) {
        user.setId(id);
        userService.editUser(user);
        return "redirect:/users";
    }

}
