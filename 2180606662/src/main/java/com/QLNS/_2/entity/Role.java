package com.QLNS._2.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.Hibernate;
import org.springframework.security.core.GrantedAuthority;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table
public class Role implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank( message = "Name is required")
    @Column(name = "name",length = 50,nullable = false)
    @Size (max = 50, message = "Name must be less than 50 character")
    private String name;

    @Size(max = 250,message = "Description must be less than 250 character")
    @Column(name = "description",length = 250)
    private String description;

    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL)
    @ToString.Exclude
    private Set<User> users = new HashSet<>();

    @Override
    public String getAuthority(){
        return name;
    }
    @Override
    public boolean equals(Objects o){
        if (this == o) return true;
        if (o==null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Role role = (Role) o;
        return getId() !=null && Objects.equals(getId(),role.getId());
    }
    @Override
    public int hasCode(){
        return getClass().hashCode;
    }
}

