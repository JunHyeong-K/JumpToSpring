package com.example.jumpToSpring.user.Service;

import com.example.jumpToSpring.DataNotFoundException;
import com.example.jumpToSpring.user.Repository.UserRepository;
import com.example.jumpToSpring.user.domain.SiteUser;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service @RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public SiteUser create(String username , String password, String email ){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        SiteUser user = new SiteUser(username ,passwordEncoder.encode(password),email);
        userRepository.save(user);
        return user;
    }

    public SiteUser getUser(String username) {
        Optional<SiteUser> siteUser = this.userRepository.findByusername(username);
        if (siteUser.isPresent()) {
            return siteUser.get();
        } else {
            throw new DataNotFoundException("siteuser not found");
        }
    }

}
