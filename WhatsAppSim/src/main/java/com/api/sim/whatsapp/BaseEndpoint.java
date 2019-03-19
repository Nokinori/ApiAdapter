package com.api.sim.whatsapp;

import com.api.sim.dbmock.DaoMock;
import com.api.sim.dbmock.entity.WAUser;
import com.api.sim.handlers.logging.Loggable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseEndpoint {

    @Autowired
    DaoMock daoMock;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    @Loggable
    public ResponseEntity login(@RequestHeader HttpHeaders headers) {
        String base64;
        base64 = "base1";
//        WAUser foundUser = daoMock.getWaUsers().stream()
//                .filter(waUser -> waUser.getUserName().equals(user.getUserName()))
//                .findFirst().get();
//        foundUser.setToken(base64);
        return ResponseEntity.ok().build();
    }
}
