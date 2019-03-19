package com.api.sim.dbmock.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@Data
@EqualsAndHashCode(callSuper = true, doNotUseGetters = true)
@RequiredArgsConstructor(staticName = "of")
public class Messages extends BaseEntity {

    private String body;

    private String title;

    private User user;

    public Optional<String> getBody() {
        return Optional.of(body);
    }

    public Optional<String> getTitle() {
        return Optional.of(title);
    }

    public Optional<User> getUser() {
        return Optional.of(user);
    }
}
