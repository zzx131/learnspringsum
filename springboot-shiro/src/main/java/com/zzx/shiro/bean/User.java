package com.zzx.shiro.bean;


import java.util.Set;

public class User {
    private String id;
    private String username;
    private String password;
    private Set<Role> roleSet;

    public User(String id, String userName, String password, Set<Role> roleSet) {
        this.id = id;
        this.username = userName;
        this.password = password;
        this.roleSet = roleSet;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoleSet() {
        return roleSet;
    }

    public void setRoleSet(Set<Role> roleSet) {
        this.roleSet = roleSet;
    }
}
