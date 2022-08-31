package com.andreamaccan.backportfolio.service;

import com.andreamaccan.backportfolio.model.User;
import java.util.List;
import java.util.Optional;

public interface IUser {
    public List<User> getUsers();
    public User getUserById(Long id);
    public Optional<User> getUserByEmail(String email);
    public void createUser(User user);
    public void editUser(User user);
    public void deleteUser(Long id);
}
