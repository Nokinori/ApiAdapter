package com.api.server.model.dao.interfaces;

import com.api.server.model.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao extends CrudRepository<User, Long> {

    List<User> findUsersByName(String name);
}
