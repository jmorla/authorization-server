package com.educmin.authorizationserver.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "AUTHORITIES")
public class Authority {

    @Id
    @Column(name = "AUTHORITY_ID")
    private Integer id;

    @Column(name = "AUTHORITY_NAME")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @ManyToMany(mappedBy = "authorities", fetch = FetchType.LAZY)
    private Set<User> users;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
