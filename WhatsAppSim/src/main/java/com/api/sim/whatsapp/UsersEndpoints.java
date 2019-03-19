package com.api.sim.whatsapp;

import com.api.sim.dbmock.DaoMock;
import com.api.sim.dbmock.entity.WAUser;
import com.api.sim.handlers.authentication.JwtTokenProvider;
import com.api.sim.handlers.logging.Loggable;
import com.api.sim.whatsapp.model.GetUserRs;
import com.api.sim.whatsapp.model.LoginRs;
import com.api.sim.whatsapp.model.LogoutRs;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZoneId;
import java.util.Optional;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;

/**
 * https://developers.facebook.com/docs/whatsapp/api/users
 */
@RestController
@RequestMapping("/v1/users/")
@Slf4j
public class UsersEndpoints {

    @Autowired
    DaoMock daoMock;

    @Autowired
    JwtTokenProvider jwtTokenProvider;

    /**
     * Log in to get your authentication token
     *
     * @return A users object containing the authentication token and the expiration date of the token
     */
    @RequestMapping(value = "login", method = RequestMethod.POST)
    @Loggable
    public ResponseEntity<LoginRs> login(@RequestHeader HttpHeaders headers) {

        Optional<String> auth = Optional.ofNullable(headers.getFirst(AUTHORIZATION));
        String base64;
        if (auth.isPresent()) {
            base64 = auth.get().replace("Basic ", "");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        String[] decoded = new String(Base64.decodeBase64(base64)).split(":");
        String username = decoded[0];
        String password = decoded[1];
        log.debug("Login with: " + username + ":" + password);

        Optional<WAUser> f = daoMock.getWaUsers().stream().filter(u -> u.getUserName().equals(username) && u.getPassword().equals(password)).findFirst();

        if (f.isPresent()) {
            f.ifPresent(u -> u.setToken(jwtTokenProvider.createToken(username)));
            LoginRs response = LoginRs.of(
                    f.get().getToken(),
                    f.get().getExpiresAfter().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime().toString());
            return ResponseEntity.ok(response);
        } else
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    /**
     * Log out of a user account and delete the token associated with that account
     *
     * @return No users (payload) object in response
     */
    @RequestMapping(value = "logout")
    @ResponseBody
    @Loggable
    public ResponseEntity<LogoutRs> logout() {
        daoMock.findByUsername(jwtTokenProvider.getUserName()).ifPresent(u -> u.setToken(""));
        return ResponseEntity.ok().build();
    }

    /**
     * Send a username and password to create a user account
     *
     * @return A users object containing the username sent in the request
     */
    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    @Loggable
    public ResponseEntity<WAUser> createUser(@RequestPart(name = "username") String username, @RequestPart(name = "password") String password) {
        return ResponseEntity.badRequest().build();
    }

    /**
     * Retrieve a user account
     *
     * @return A users object containing the username sent in the request and that user's role
     */
    @RequestMapping(path = "{username}", method = RequestMethod.GET)
    @ResponseBody
    @Loggable
    public ResponseEntity<GetUserRs> getUser(@PathVariable("username") String username) {
        try {
            if (jwtTokenProvider.getUserName().equals(username)) {
                WAUser waUser = daoMock.findByUsername(username).get();
                return ResponseEntity.ok(GetUserRs.of(waUser.getUserRole(), waUser.getUserName()));
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            log.error("Unknown error", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }


    }

    /**
     * Send a new password to update a user's password
     *
     * @return A users object containing the username sent in the request
     */
    @RequestMapping(path = "{username}", method = RequestMethod.PUT)
    @ResponseBody
    @Loggable
    public ResponseEntity<Object> updatePassword(@PathVariable("username") String username) {
        return ResponseEntity.badRequest().build();
    }

    /**
     * Delete a user account with the username sent in the request
     *
     * @return A users object containing the username sent in the request
     */
    @RequestMapping(path = "{username}", method = RequestMethod.DELETE)
    @ResponseBody
    @Loggable
    public ResponseEntity<WAUser> deleteUser(@PathVariable("username") String username) {
        return ResponseEntity.badRequest().build();
    }


}
