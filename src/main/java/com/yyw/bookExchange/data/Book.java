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
    String save;
    @Column
    String name;

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

    public String getSave() {
        return save;
    }

    public void setSave(String save) {
        this.save = save;
    }

    public Book() {
    }
}
