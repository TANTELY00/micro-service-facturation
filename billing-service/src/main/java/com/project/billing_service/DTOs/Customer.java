package com.project.billing_service.DTOs;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter @Setter
public class Customer implements Serializable {
    private Long id;
    private String name;
    private String email;
}
