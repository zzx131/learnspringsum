package com.zzx.collection.java8;

public class Role {
    private String id;
    private String rname;

    public Role() {
    }

    public Role(String id, String rname) {
        this.id = id;
        this.rname = rname;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id='" + id + '\'' +
                ", rname='" + rname + '\'' +
                '}';
    }
}
