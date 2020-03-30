package com.zzx.collection.java8;

import java.util.List;

public class User {
    private String id;
    private String uName;
    private int age;
    private List<Role> roles;

    public User() {
    }

    public User(String id, String uName, int age) {
        this.id = id;
        this.uName = uName;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", uName='" + uName + '\'' +
                ", roles=" + roles +
                '}';
    }
}
