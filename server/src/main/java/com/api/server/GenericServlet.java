package com.api.server;

import com.api.server.handlers.logging.Loggable;
import com.api.server.model.dao.interfaces.DaoFactory;
import com.api.server.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GenericServlet {

    @Autowired
    DaoFactory daoFactory;


    @RequestMapping(path = "/", method = RequestMethod.GET)
    @Loggable
    public Object get() {
        Object a = new Object();
        daoFactory.getUserDao().save(User.of("asd", "ad", "asd", "asd"));
        return a;
    }

    @RequestMapping(path = "/a", method = RequestMethod.GET)
    @Loggable
    public Object getA() {
        Object a = new Object();
        daoFactory.getUserDao().save(User.of("asd", "ad", "asd", "asd"));
        return a;
    }
}
