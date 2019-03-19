package com.api.server.model.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;
import java.util.Optional;

@Entity
@Data
@EqualsAndHashCode(callSuper = true, doNotUseGetters = true)
@RequiredArgsConstructor(staticName = "of")
public class User extends BaseEntity {

    @Column
    @NonNull
    private String name;

    @Column
    @NonNull
    private String login;

    @Column
    @NonNull
    private String password;

    @Column
    @NonNull
    private String waAuthkey;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Messages> messages;

    @OneToOne(cascade = CascadeType.ALL)
    private UserSession userSession;

    public Optional<String> getName() {
        return Optional.of(name);
    }

    public Optional<String> getLogin() {
        return Optional.of(login);
    }

    public Optional<String> getPassword() {
        return Optional.of(password);
    }

    public Optional<String> getWaAuthkey() {
        return Optional.of(waAuthkey);
    }

    public Optional<List<Messages>> getMessages() {
        return Optional.of(messages);
    }

    public Optional<UserSession> getUserSession() {
        return Optional.of(userSession);
    }
}
