package com.api.server.model.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;

@Entity
@Data
@EqualsAndHashCode(callSuper = true, doNotUseGetters = true)
@RequiredArgsConstructor(staticName = "of")
public class WAUser extends BaseEntity {



}
