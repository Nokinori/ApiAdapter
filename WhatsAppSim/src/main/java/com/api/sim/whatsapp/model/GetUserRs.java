package com.api.sim.whatsapp.model;

import com.api.sim.dbmock.entity.UserRole;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor(staticName = "of")
public class GetUserRs {

    @NonNull
    UserRole ROLES;
    @NonNull
    String username;

}
