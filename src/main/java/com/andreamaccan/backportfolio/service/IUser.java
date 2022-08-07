package com.andreamaccan.backportfolio.service;

import com.andreamaccan.backportfolio.model.User;
import java.util.List;

public interface IUser {
    public List<User> getUsers();
    public User getUserById(Long id);
    public void saveUser(User user);
    public void editUser(User user);
    public void deleteUser(Long id);
}
