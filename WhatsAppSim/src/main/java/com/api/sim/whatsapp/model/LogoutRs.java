package com.api.sim.whatsapp.model;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor(staticName = "of")
public class LogoutRs {

    @NonNull
    String username;
}
