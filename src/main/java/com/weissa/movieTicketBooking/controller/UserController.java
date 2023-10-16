package com.weissa.movieTicketBooking.controller;

import com.weissa.movieTicketBooking.constant.Constant;
import com.weissa.movieTicketBooking.entities.User;
import com.weissa.movieTicketBooking.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = Constant.USER_CONTROLLER_REQUEST)
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping(value = "/{Id}", produces = {"application/json"})
    public @ResponseBody User getUserById(@PathVariable final Integer Id) {
        return userService.getUserById(Id);
    }

    @GetMapping(value = "/all", produces = {"application/json"})
    public @ResponseBody List<User> getAllUsers() {
        return userService.getAll();
    }

    @PostMapping(value = "/add")
    public @ResponseBody User addNewUser(@RequestBody User user) {
        return userService.save(user);
    }

    @DeleteMapping("/{Id}")
    public @ResponseBody void deleteUserById(@PathVariable final Integer Id) {
        userService.delete(Id);
    }
}
