package lx.controller;

import lx.domain.User;
import lx.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        User save = userRepository.save(user);
        return ResponseEntity.ok(save);
    }
}
