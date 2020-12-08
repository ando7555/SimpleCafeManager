package com.sfl.simplecafemanager.service;

import com.sfl.simplecafemanager.domain.entity.user.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);

    User findByFirstNameAndLastName(String firstName, String lastName);

    User getUserById(long id);

    List<User> getAllUsers();
}
