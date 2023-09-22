package com.example.webprofile.model.entity;

import com.google.gson.Gson;
import jakarta.json.bind.annotation.JsonbTransient;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@Data
@SuperBuilder

@Entity(name = "groupEntity")
@Table(name="group_tbl")

@NamedQueries({
        @NamedQuery(name="Group.FindByParentId", query = "select oo from groupEntity oo where oo.parent.id=:parentId"),
        @NamedQuery(name="Group.FindParents", query = "select oo from groupEntity oo where oo.parent.id is null")
})
public class Group extends Base {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Pattern(regexp = "^[A-Za-z0-9]{3,30}$", message = "Invalid group title")
    @Column(name = "g_title",length = 30)
    private String title;

    @ManyToOne
    @JoinColumn(name = "g_parent_id")
    private Group parent;

    @Override
    public String toString() {
       return new Gson().toJson(this);
    }
}
