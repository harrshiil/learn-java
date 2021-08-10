package com.sfl.americantutor.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "at_authority")
public class ATAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "atAuthorities")
    @JsonIgnore
    private Set<ATUser> atUsers = new HashSet<>();

    public Long getId() {
        return id;
    }

    public ATAuthority id(Long id) {
        this.id = id;
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public ATAuthority name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<ATUser> getAtUsers() {
        return atUsers;
    }

    public ATAuthority atUsers(Set<ATUser> atUsers) {
        this.atUsers = atUsers;
        return this;
    }

    public void setAtUsers(Set<ATUser> atUsers) {
        this.atUsers = atUsers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ATAuthority atAuthority = (ATAuthority) o;
        if (atAuthority.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), atAuthority.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "ATAuthority{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", atUsers=" + atUsers +
                '}';
    }
}
