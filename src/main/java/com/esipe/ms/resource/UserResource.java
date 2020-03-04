package com.esipe.ms.resource;

import com.esipe.ms.domain.User;
import com.esipe.ms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(value = "users", produces = (MediaType.APPLICATION_JSON_VALUE))
public class UserResource {
    //@Autowired // @Qualifier("") si 2
    private UserService userService;
    @Autowired
    public UserResource(UserService us){
        userService = us;
    }
    @GetMapping("{email}")
    public User getOne(@PathVariable("email") String email){
        return userService.getOne(email);
    }

    @GetMapping
    public HashMap<String, User> getAll(){
        return userService.getAll();
    }

    @PostMapping
    public void add(@RequestBody User user){
        userService.add(user);
    }

    @PutMapping("{email}")
    public void update( @PathVariable("email") String email, User user){
        if(!email.equals(user.getEmail())){
            throw new RuntimeException("update user exception");
        }
        userService.update(user);
    }

    @DeleteMapping("{email}")
    public void delete(@PathVariable("email") String email){
        userService.delete(email);
    }
}
