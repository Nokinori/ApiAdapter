package com.api.server.model.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Optional;

@Entity
@Data
@EqualsAndHashCode(callSuper = true, doNotUseGetters = true)
@RequiredArgsConstructor(staticName = "of")
public class Messages extends BaseEntity {

    @Column
    private String body;

    @Column
    private String title;

    @ManyToOne
    @JoinColumn(name = "user_id")
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
