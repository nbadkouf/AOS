package com.esipe.ms.repository;

import com.esipe.ms.domain.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class UserRepository {
    private Map<String, User> users = new HashMap<>();

    public void save(User user){
        users.put(user.getEmail(), user);
    }
    public void update(User user){
        if(!ifExists(user.getEmail())){
            throw new RuntimeException("user not found");
        }
        users.put(user.getEmail(), user);
    }
    public User getOne(String email){
        return users.get(email);
    }
        public HashMap<String, User> getAll(){
        return (HashMap<String, User>) users;
    }
    public void delete(String email){
        if(!ifExists(email)){
            throw new RuntimeException("user not found");
        }
        users.remove(email);
    }
    private boolean ifExists(String email){
        return users.containsKey(email);
    }
}
