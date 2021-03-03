package com.gunnarsson.smartlighter.io.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity(name="users")
public class UserEntity implements Serializable {
    private static final long serialVersionUID = 5012315223526710046L;

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String userId;

    @Column(nullable = false,length = 20)
    private String firstName;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String encryptedPassword;
}
