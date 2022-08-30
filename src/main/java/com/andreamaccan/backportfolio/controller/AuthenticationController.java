package com.andreamaccan.backportfolio.controller;

import com.andreamaccan.backportfolio.model.Jwt;
import com.andreamaccan.backportfolio.model.Message;
import com.andreamaccan.backportfolio.model.Login;
import com.andreamaccan.backportfolio.components.JwtProvider;
import com.andreamaccan.backportfolio.enums.RoleEnums;
import com.andreamaccan.backportfolio.model.Role;
import com.andreamaccan.backportfolio.model.User;
import com.andreamaccan.backportfolio.service.RoleService;
import com.andreamaccan.backportfolio.service.UserService;
import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthenticationController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtProvider jwtProvider;
    
    @PostMapping("/user/create")
    public ResponseEntity<?> createUser(@RequestBody User newUser, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return new ResponseEntity(new Message("Invalid fields"), HttpStatus.BAD_REQUEST);
        }

        if (userService.existsByEmail(newUser.getEmail())) {
            return new ResponseEntity(new Message("User already exists"), HttpStatus.BAD_REQUEST);
        }

        User user = new User(
                newUser.getFirstname(),
                newUser.getLastname(),
                newUser.getBirthday(),
                newUser.getNationality(),
                newUser.getEmail(),
                passwordEncoder.encode(newUser.getPassword()),
                newUser.getAbout(),
                newUser.getTitle(),
                newUser.getAvatar(),
                newUser.getBanner(),
                newUser.getLocation()
        );

        Set<Role> roles = new HashSet<>();

        roles.add(roleService.getRoleByName(RoleEnums.ROLE_USER).get());

        if (newUser.getRoles().contains("admin")) {
            roles.add(roleService.getRoleByName(RoleEnums.ROLE_ADMIN).get());
        }
        user.setRoles(roles);
        userService.createUser(user);

        return new ResponseEntity(new Message("Saved user"), HttpStatus.CREATED);
    }
       
    @PostMapping("/login")
    public ResponseEntity<Jwt> login(@RequestBody Login login, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity(new Message("Invalid fields"), HttpStatus.BAD_REQUEST);
        }

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                login.getEmail(), login.getPassword()
        ));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String tokenGenerated = jwtProvider.generateToken(authentication);

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        Jwt jwt = new Jwt(tokenGenerated, userDetails.getUsername(), userDetails.getAuthorities());

        return new ResponseEntity(jwt, HttpStatus.OK);
    }
}
