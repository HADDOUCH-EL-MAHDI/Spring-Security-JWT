package com.example.crudapplication.controller;

import com.example.crudapplication.dto.AuthRequest;
import com.example.crudapplication.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Auth")
//@CrossOrigin(origins = {"http://localhost:8081","http://127.0.0.1:3000","http://192.168.43.79:3000","http://localhost:8000","http://localhost:3000","http://192.168.252.105:3000","http://192.168.252.115:3000"})
public class AuthController {

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/hello")
    public String ex(@RequestBody AuthRequest authRequest){
        return authRequest.getUsername();
    }
    @PostMapping("/authenticate")
    public String authenticateAndGetToken(@RequestBody AuthRequest authRequest) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        if(authentication.isAuthenticated()) {
            return jwtService.generateToken(authRequest.getUsername());
        }else{
            throw new UsernameNotFoundException("invalid user request !");
        }
    }
}
