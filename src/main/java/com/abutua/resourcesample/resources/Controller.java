package com.abutua.resourcesample.resources;


import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abutua.resourcesample.model.Message;

@RestController
@RequestMapping("resources")
public class Controller {
    
    @GetMapping("user")
    public ResponseEntity<Message> getUserMessage(){
        System.out.println("Hello user");
        return ResponseEntity.ok().body(new Message("Hello from user"));
    }

    @GetMapping("admin")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<Message> getAdminMessage(){
        System.out.println("Hello admin");
        return ResponseEntity.ok().body(new Message("Hello from admin"));
    }
}