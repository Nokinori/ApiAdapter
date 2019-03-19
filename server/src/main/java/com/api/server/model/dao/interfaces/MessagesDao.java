package com.api.server.model.dao.interfaces;

import com.api.server.model.entity.Messages;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
interface MessagesDao extends CrudRepository<Messages, Long> {

}
