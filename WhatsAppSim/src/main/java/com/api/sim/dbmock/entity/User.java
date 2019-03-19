package com.api.sim.dbmock.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@Data
@EqualsAndHashCode(callSuper = true, doNotUseGetters = true)
@RequiredArgsConstructor(staticName = "of")
public class User extends BaseEntity implements Serializable {

    @NonNull
    private String name ;

    @NonNull
    private String login;

    @NonNull
    private String password;

    private String token;

    private String waAuthkey;

    private List<Messages> messages;

    private UserSession userSession;
}
