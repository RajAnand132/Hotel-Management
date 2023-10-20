package com.hotelManagement.service;

import com.hotelManagement.model.Guest;
import com.hotelManagement.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    public String createUser(Guest guest) {
        userRepository.save(guest);
        return "User Created";
    }
}
