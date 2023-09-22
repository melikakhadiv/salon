package com.example.webprofile.model.entity;

import jakarta.enterprise.context.SessionScoped;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@Data
@SuperBuilder


@Entity(name="personEntity")
@Table(name="person_tbl")

@NamedQueries({
        @NamedQuery(name = "Person.FindByFamily",query = "select oo from personEntity oo where oo.family=:family")
})
public class Person extends Base{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name="p_name",length = 30)
    @Pattern(regexp = "^[A-Za-z]{2,30}$", message = "Invalid Name")
    private String name;

    @Column(name="p_family",length = 30)
    @Pattern(regexp = "^[A-Za-z]{2,30}$", message = "Invalid Family")
    private String family;
}
