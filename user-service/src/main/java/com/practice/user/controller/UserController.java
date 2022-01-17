package com.practice.user.controller;

import com.practice.user.VO.ResponseTemplateVO;
import com.practice.user.entity.User;
import com.practice.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/")
    public User saveUser(@RequestBody User user) {
        log.info("inside saveUser method of userController");
        return userService.saveUser(user);
    }

    @GetMapping("/{id}")
    public ResponseTemplateVO getUserWithDepartment(@PathVariable("id") Long id) {
        log.info("inside getUserWithDepartment method of userController");
        return userService.getUserWithDepartment(id);
    }
}
