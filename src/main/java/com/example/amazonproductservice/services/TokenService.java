package com.example.amazonproductservice.services;

import com.example.amazonproductservice.dtos.UserDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TokenService {
    private RestTemplate restTemplate;
    public TokenService(RestTemplate restTemplate){
        this.restTemplate=restTemplate;
    }
    public boolean validateToken(String token){
        UserDTO userDTO=restTemplate.getForObject("http://localhost:8080/user/validate/"+token,UserDTO.class);
        return userDTO != null && userDTO.getName() != null && userDTO.getEmail() != null;
    }
}
