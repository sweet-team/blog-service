package lx.controller;

import lx.domain.User;
import lx.repository.UserRepository;
import lx.security.Role;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User user){
        if(user.getRole() == null || !Role.containIn(user.getRole())){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(user);
        }
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        User save = userRepository.save(user);
        return ResponseEntity.ok(save);
    }
}
