package com.example.springbootproject.service;

import com.example.springbootproject.entity.User;
import com.example.springbootproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    //post method
    public User saveUser(User user){
        return repository.save(user);
    }
    public List<User> saveUsers(List<User> users){
        return repository.saveAll(users);
    }

    //get
    public List<User> getUsers(){
        return repository.findAll();
    }
    public User getUserById(int id){
        return repository.findById(id).orElse(null);
    }
    public User getUserByName(String name){
        return repository.findByName(name);
    }

    //delete
    public String deleteUser(int id){
        repository.deleteById(id);
        return "User deleted..."+id;
    }

    public User updateUser(User user){
        User existingUser=repository.findById(user.getId()).orElse(null);
        existingUser.setName(user.getName());
        existingUser.setAge(user.getAge());

        return repository.save(existingUser);
    }



}
