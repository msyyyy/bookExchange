package com.yyw.bookExchange.data;



import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
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

    public void setId(String password) {
        this.password = password;
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
