package com.dm.bookwithnotes.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.security.core.GrantedAuthority;

import java.util.Set;

@Entity
@Table(name="roles")
@Data
@AllArgsConstructor
@EqualsAndHashCode
public class Role implements GrantedAuthority {
    @Id
    private Long id;
    @Column(unique=true)
    private String name;
    @Transient
    @ManyToMany(mappedBy = "roles")
    private Set<User> users;
    public Role() {
    }

    public Role(long l, String roleUser) {
    }

    @Override
    public String getAuthority() {
        return getName();
    }
}
