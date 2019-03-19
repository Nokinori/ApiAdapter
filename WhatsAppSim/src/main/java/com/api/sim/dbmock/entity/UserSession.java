package com.api.sim.dbmock.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.Optional;

@Data
@EqualsAndHashCode(callSuper = true, doNotUseGetters = true)
@RequiredArgsConstructor(staticName = "of")
public class UserSession extends BaseEntity {

    private String session;

    private LocalDateTime creationTime;

    private LocalDateTime lastModificationTime;

    private LocalDateTime expired;

    private User user;

    public void presetTime() {
        if (creationTime == null) creationTime = LocalDateTime.now();
        lastModificationTime = LocalDateTime.now();
    }

    public Optional<String> getSession() {
        return Optional.of(session);
    }

    public Optional<LocalDateTime> getCreationTime() {
        return Optional.of(creationTime);
    }

    public Optional<LocalDateTime> getLastModificationTime() {
        return Optional.of(lastModificationTime);
    }

    public Optional<LocalDateTime> getExpired() {
        return Optional.of(expired);
    }

    public Optional<User> getUser() {
        return Optional.of(user);
    }
}
