package com.toyproj.pinchhitterhomerun.model;

import lombok.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
public class Member {
    @Id @GeneratedValue
    private Long id;

    private String loginId;

    private String passWord;

    @ManyToOne
    @JoinColumn(name = "id", insertable = false, updatable = false)
    private PasswordHint passwordHint;

    private String sns;

    private String name;

    private String sex;

    private String phone;

    @ManyToOne
    @JoinColumn(name = "id", insertable = false, updatable = false)
    private Role role;

    private String email;

    private String address;

    private String profileImage;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastLoginDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date deletedDate;

    public Member() {
    }

    public Member(String loginId, String passWord, PasswordHint passwordHint, String sns, String name, String sex, String phone, Role role, String email, String address, String profileImage) {
        this.loginId = loginId;
        this.passWord = passWord;
        this.passwordHint = passwordHint;
        this.sns = sns;
        this.name = name;
        this.sex = sex;
        this.phone = phone;
        this.role = role;
        this.email = email;
        this.address = address;
        this.profileImage = profileImage;
        this.lastLoginDate = new Date();
        this.createdDate = new Date();
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public void setLastLoginDate(Date lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }
}