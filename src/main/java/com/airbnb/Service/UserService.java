package com.airbnb.Service;

import com.airbnb.Entity.PropertyUser;
import com.airbnb.Repository.PropertyUserRepository;
import com.airbnb.dto.LoginDto;
import com.airbnb.dto.PropertyUserDto;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private PropertyUserRepository userRepository;
    private JWTService jwtService;

    public UserService(PropertyUserRepository userRepository, JWTService jwtService) {
        this.userRepository = userRepository;
        this.jwtService = jwtService;
    }

    public PropertyUser addUser(PropertyUserDto propertyUserDto) {
        PropertyUser puser = new PropertyUser();
        puser.setFirstName(propertyUserDto.getFirstName());
        puser.setLastName(propertyUserDto.getLastName());
        puser.setUsername(propertyUserDto.getUsername());
        puser.setEmail(propertyUserDto.getEmail());
        puser.setUserRole(propertyUserDto.getUserRole());
        puser.setPassword(BCrypt.hashpw(propertyUserDto.getPassword(), BCrypt.gensalt(10)));
        PropertyUser savedUser = userRepository.save(puser);
        return savedUser;

    }

    public String verifyLogin(LoginDto loginDto) {
        Optional<PropertyUser> byUsername = userRepository.findByUsername(loginDto.getUsername());
        if(byUsername.isPresent()) {
            PropertyUser propertyUser = byUsername.get();
            if (BCrypt.checkpw(loginDto.getPassword(), propertyUser.getPassword())) {
                return jwtService.generateToken(propertyUser);
            }
        }
        return null;
    }
}

