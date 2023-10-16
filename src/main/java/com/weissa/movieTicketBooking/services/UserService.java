package com.weissa.movieTicketBooking.services;

import com.weissa.movieTicketBooking.entities.User;
import com.weissa.movieTicketBooking.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User save(User user) {
        return userRepository.save(user);
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User getUserById(int id) {
        return userRepository.findById(id);
    }

    public void delete(int id) {
        userRepository.deleteById(id);
    }

    /*public String passwordEncode(String password) {
        String bPass = null;
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        bPass = passwordEncoder.encode(password);
        return bPass;
    }

    public boolean checkPassword(String password, String encodedPassword) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.matches(password, encodedPassword);
    }*/

}
