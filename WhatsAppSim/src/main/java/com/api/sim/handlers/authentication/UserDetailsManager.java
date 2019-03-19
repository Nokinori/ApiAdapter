package com.api.sim.handlers.authentication;

import com.api.sim.dbmock.DaoMock;
import com.api.sim.dbmock.entity.WAUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsManager implements UserDetailsService {

    @Autowired
    private DaoMock daoMock;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final Optional<WAUser> user = daoMock.findByUsername(username);

        if (user.isPresent()) {
            return User.withUsername(username)
                    .password(user.get().getPassword())
                    .authorities(user.get().getUserRole().name())
                    .accountExpired(false)
                    .accountLocked(false)
                    .credentialsExpired(false)
                    .disabled(false)
                    .build();
        } else {
            throw new UsernameNotFoundException("User '" + username + "' not found");
        }
    }
}
