package com.app.vitalsign.service;

import com.app.vitalsign.config.auth.User;
import com.app.vitalsign.config.auth.UserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.http.ResponseEntity;
import java.util.ArrayList;
import java.util.List;

@Service
public class AppUserDetailsService implements UserDetailsService {

   @Autowired
   UserClient userClient;

    public ResponseEntity<List<User>> getUsers(String token) {
        return userClient.getAllUser("Bearer " + token);
    }

    public String getToken() {
        return userClient.login("admin", "admin");
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String token = getToken();
        ResponseEntity<List<User>> userListRes = getUsers(token);

        if (userListRes.getBody() == null || userListRes.getBody().isEmpty()) {
            throw new UsernameNotFoundException("No users found");
        }

        User matchedUser = userListRes.getBody().stream()
                .filter(user -> user.getName().equals(username))
                .findFirst()
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));

        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(matchedUser.getRole()));
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        return new org.springframework.security.core.userdetails.User(
                matchedUser.getName(),
                passwordEncoder.encode(matchedUser.getName()),
                authorities
        );
    }
}
