package com.redhat.restcruddatagrid.infinispan.controller;
 
import java.util.Random;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
 
import com.redhat.restcruddatagrid.infinispan.model.User;
import com.redhat.restcruddatagrid.infinispan.repository.UserRepo;
 
@RestController
public class UserController {
    @Autowired
    UserRepo userRepo;
     
    @RequestMapping("/findUserById")
    public User findUserById(@RequestParam("id") long id){
        return userRepo.findByCode(id);
    }
 
    @RequestMapping("/putUser")
    public String putUser(@RequestParam("userNumber") int userNumber){
        Random r = new Random();
        for(int i=0; i<userNumber; i++){
            userRepo.putUserToCache(r.nextLong());
        }
        return "Done";
    }
     
    @RequestMapping("/evictAllUsers")
    public String evictAll(){
        userRepo.evictAllEntries();
        return "Done";
    }
     
    @RequestMapping("/evictUserEntry")
    public String evictEntry(@RequestParam("id") long id){
        userRepo.evictEntry(id);
        return "Done";
    }
}