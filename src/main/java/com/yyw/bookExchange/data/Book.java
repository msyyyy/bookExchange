package com.yyw.bookExchange.data;

import javax.persistence.*;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue
    Long pid;
    @Column
    String isbn;
    @Column
    Long ppid;
    @Column
    String details;
    @Column
    int love;
    @Column
    int save;
    @Column
    String name;
    @Column
    int notLove;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Long getPpid() {
        return ppid;
    }

    public void setPpid(Long ppid) {
        this.ppid = ppid;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }


    public int getLove() {
        return love;
    }

    public void setLove(int love) {
        this.love = love;
    }

    public int getNotLove() {
        return notLove;
    }

    public void setNotLove(int notLove) {
        this.notLove = notLove;
    }

    public int getSave() {
        return save;
    }

    public void setSave(int save) {
        this.save = save;
    }

    public Book() {
    }
}
