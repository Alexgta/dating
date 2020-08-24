package com.job4j.dating.entity;

import com.job4j.dating.entity.dict.WebRole;
import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name= "web_user", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class WebUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="email")
    private String email;

    @Column(name="password")
    private String password;

    @Column(name="cur_role")
    private String curRole;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "web_user_role",
            joinColumns = @JoinColumn(
                    name = "web_user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "web_role_id", referencedColumnName = "id"))
    private Collection<WebRole> roles;


    // Standart constractor, getters and setters.
    public WebUser() {
    }

    public WebUser(Long id, String email, String name, String password, String curRole) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.password = password;
        this.curRole = curRole;
    }

    public WebUser(Long id, String email, String name, String password, String curRole, Collection<WebRole> roles) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.password = password;
        this.curRole = curRole;
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCurRole() {
        return curRole;
    }

    public void setCurRole(String curRole) {
        this.curRole = curRole;
    }

    public Collection<WebRole> getRoles() {
        return roles;
    }

    public void setRoles(Collection<WebRole> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + "*********" + '\'' +
                ", roles=" + roles +
                '}';
    }

}
