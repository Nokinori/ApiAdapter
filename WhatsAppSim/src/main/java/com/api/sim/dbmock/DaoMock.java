package com.api.sim.dbmock;

import com.api.sim.dbmock.entity.WAUser;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Data
public class DaoMock {
    List<WAUser> waUsers = new ArrayList<>();

    public DaoMock() {
        waUsers.add(WAUser.of(
                "defaultToken",
                "user1",
                "password1",
                "base1"));
    }

    public Optional<WAUser> findByUsername(String name) {
        return waUsers.stream().filter(u->u.getUserName().equals(name)).findFirst();
    }
}
