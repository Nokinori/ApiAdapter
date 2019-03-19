package com.api.server.model.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;
import java.util.Optional;

@Entity
@Data
@EqualsAndHashCode(callSuper = true, doNotUseGetters = true)
@RequiredArgsConstructor(staticName = "of")
public class UserSession extends BaseEntity {

    @Column
    private String session;

    @Column
    private LocalDateTime creationTime;

    @Column
    private LocalDateTime lastModificationTime;

    @Column
    private LocalDateTime expired;

    @OneToOne
    private User user;

    @PrePersist
    @PreUpdate
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
