package com.api.server.model.dao.interfaces;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Component
public class DaoFactory {

    @Autowired
    UserDao userDao;

    @Autowired
    UserSessionDao userSessionDao;

    @Autowired
    MessagesDao messagesDao;

}
