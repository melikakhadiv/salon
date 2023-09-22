package com.example.webprofile.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@Data
@SuperBuilder


@Entity(name="roleEntity")
@Table(name="role_tbl")

public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name="r_name",length = 30, unique = true)
    @Pattern(regexp = "^[A-Za-z\\s]{2,30}$", message = "Invalid Role")
    private String role;
}
