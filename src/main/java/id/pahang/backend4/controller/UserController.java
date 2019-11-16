package id.pahang.backend4.controller;

import id.pahang.backend4.model.User;
import id.pahang.backend4.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @PostMapping("/byemail")
    public User getByEmail(@ModelAttribute GetByEmailReqBody getByEmailReqBody){
        System.out.println(userRepository.findByEmail(getByEmailReqBody.getEmail()).get(0).toString());
        return userRepository.findByEmail(getByEmailReqBody.getEmail()).get(0);
    }

    @PostMapping()
    public User createUser(@ModelAttribute User user){
        return userRepository.save(user);
    }

    @DeleteMapping("/{userId}")
    public User deleteUser(@PathVariable Long userId){
        User user = userRepository.findById(userId).get();
        userRepository.deleteById(userId);
        return user;
    }

    @GetMapping()
    public List getAllUser(){
        return userRepository.findAll();
    }

    @GetMapping("/{userId}")
    public User getUser(@PathVariable Long userId){
        return userRepository.findById(userId).get();
    }

    @PutMapping("/{userId}")
    public User updateUser(@PathVariable Long userId, @ModelAttribute User updateUser){
        User user =  userRepository.findById(userId).get();
        if(updateUser.getEmail()!=null){
            user.setEmail(updateUser.getEmail());
        }
        if(updateUser.getName()!=null){
            user.setName(updateUser.getName());
        }
        if(updateUser.getType()!=0){
            user.setType(updateUser.getType());
        }
        if(updateUser.getImgDownloadUrl()!=null){
            user.setImgDownloadUrl(updateUser.getImgDownloadUrl());
        }
        return userRepository.save(user);
    }
}

class GetByEmailReqBody {
    private String email;

    public GetByEmailReqBody(String email) {
        this.email = email;
    }

    public GetByEmailReqBody() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}


