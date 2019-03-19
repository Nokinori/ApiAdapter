package com.api.server.model.dao.interfaces;

import com.api.server.model.entity.UserSession;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
interface UserSessionDao extends CrudRepository<UserSession, Long> {
}
