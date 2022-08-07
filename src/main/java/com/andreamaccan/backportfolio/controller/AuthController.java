//package com.andreamaccan.backportfolio.controller;
//
//import com.andreamaccan.backportfolio.controller.UserController;
//import com.andreamaccan.backportfolio.service.UserService;
//import com.andreamaccan.backportfolio.model.User;
//import com.andreamaccan.backportfolio.utils.JWTUtil;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;
//
///**
// *
// * @author Andrea Maccan
// */
//@RestController
//public class AuthController {
//
//    @Autowired
//    private UserService userService;
//
//    @Autowired
//    private JWTUtil jwtUtil;
//
//    @PostMapping("/login")
//    @ResponseBody
//    public String login(@RequestBody User user) {
//        User loggedUser = userService.getUserByCredentials(user);
//        if (loggedUser != null) {
//            String token = jwtUtil.create(String.valueOf(loggedUser.getId()), loggedUser.getEmail());
//            return token;
//        }
//        return "Invalid token";
//    }
//
//}
//
