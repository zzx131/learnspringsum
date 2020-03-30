package com.zzx.springbootjpa.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity(name = "sys_user")
public class SysUser {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;

    @Column(name = "brithday")
    @Temporal(TemporalType.DATE)
    private Date brithday;


}
