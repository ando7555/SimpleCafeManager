package com.sfl.simplecafemanager.service.impl;

import com.sfl.simplecafemanager.domain.entity.user.User;
import com.sfl.simplecafemanager.domain.repository.UserRepository;
import com.sfl.simplecafemanager.exception.ResourceNotFoundException;
import com.sfl.simplecafemanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User saveUser(User user){
        return userRepository.save(user);
    }

    @Override
    public User findByFirstNameAndLastName(String firstName, String lastName){
        return userRepository.findUserByUsernameAndPassword(firstName, lastName);
    }

    @Override
    public User getUserById(long id){
        return userRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Resource not found for this id " + id));
    }

    @Override
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
}
