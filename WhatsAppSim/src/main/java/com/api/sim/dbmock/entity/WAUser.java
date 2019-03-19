package com.api.sim.dbmock.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = true, doNotUseGetters = true)
@RequiredArgsConstructor(staticName = "of")
public class WAUser extends BaseEntity {

    @NonNull
    private String token;

    @NonNull
    private String userName;

    @NonNull
    private String password;

    @NonNull
    private String base64;

    private UserRole userRole = UserRole.ROLE_USER;

    private Date expiresAfter;


}
