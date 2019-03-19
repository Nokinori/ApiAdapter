package com.api.sim.whatsapp.model;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor(staticName = "of")
public class LoginRs {

    @NonNull
    private String token;

    @NonNull
    private String expiresAfter;
}
