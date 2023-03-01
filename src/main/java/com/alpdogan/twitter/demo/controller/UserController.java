package com.alpdogan.twitter.demo.controller;

import com.alpdogan.twitter.demo.entity.Tweet;
import com.alpdogan.twitter.demo.entity.User;
import com.alpdogan.twitter.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/saveUser")
    private ResponseEntity<String> saveUser(@RequestBody User user)
    {
        String saveText = userService.saveUser(user);

        return new ResponseEntity<>(saveText, HttpStatus.OK);
    }

    @GetMapping("/findUser")
    public ResponseEntity<User> findUserById (@RequestParam int userId)
    {
        User user = userService.findUserById(userId);

        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("/updateUser")
    public ResponseEntity<String> updateUser (@RequestBody User user)
    {
        String updateText = userService.updateUserById(user);

        return new ResponseEntity<>(updateText, HttpStatus.OK);
    }

    @PostMapping("/addTweetToUser")
    public ResponseEntity<String> addTweetToUser (@RequestBody User user, @ModelAttribute Tweet tweet)
    {
        String addCourseText = userService.addTweetToUserById(user, tweet);

        return new ResponseEntity<>(addCourseText, HttpStatus.OK);
    }

    @DeleteMapping("/deleteUser")
    public ResponseEntity<String> deleteUser (@RequestParam int userId)
    {
        String deleteText = userService.deleteUserById(userId);

        return new ResponseEntity<>(deleteText, HttpStatus.OK);
    }

    @GetMapping("/findAllUsers")
    public ResponseEntity<List<User>> findAllUsers ()
    {
        List<User> users = userService.findAllUsers();

        return new ResponseEntity<>(users, HttpStatus.OK);
    }

}
