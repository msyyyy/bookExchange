package com.yyw.bookExchange.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue
    Long pid;
    @Column
    private String isbn;
    @Column
    private
    Long ppid;
    @Column
    private
    String details;
    @Column
    private
    int love;
    @Column
    private
    int save;
    @Column
    private
    String name;
    @Column
    private
    int notLove;
    @Column
    private int value;
    @Column
    private int man;
    @Column
    private String author;
    @Column
    private String press;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press;
    }

    public String getPress_time() {
        return press_time;
    }

    public void setPress_time(String press_time) {
        this.press_time = press_time;
    }

    @Column
    private String press_time;

    public int getMan() {
        return man;
    }

    public void setMan(int man) {
        this.man = man;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

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
