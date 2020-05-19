package com.yyw.bookExchange.data;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "user")
public class User {
    public User() {
    }

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }


    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password;
    }

    public User(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String name;

    @Column
    private String password;

    public long getLove() {
        return love;
    }

    public void setLove(long love) {
        this.love = love;
    }

    @Column
    private long love;

    @Column
    private long notlove;

    @Column
    private long save;

    @Column
    private String icon;

    @Column
    private String phone;

    @Column
    private String e_mail;

    @Column
    private int status;

    @Column
    private String createTime;

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getE_mail() {
        return e_mail;
    }

    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public int isSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public User(String name, String password, long love, long notlove, long save, String icon, String phone, String e_mail, int status, String createTime, int  sex, String birth) {
        this.name = name;
        this.password = password;
        this.love = love;
        this.notlove = notlove;
        this.save = save;
        this.icon = icon;
        this.phone = phone;
        this.e_mail = e_mail;
        this.status = status;
        this.createTime = createTime;
        this.sex = sex;
        this.birth = birth;
    }

    @Column
    private int sex;

    @Column
    private String birth;

    public long getNotlove() {
        return notlove;
    }

    public void setNotlove(long notlove) {
        this.notlove = notlove;
    }

    public long getSave() {
        return save;
    }

    public void setSave(long save) {
        this.save = save;
    }
}
