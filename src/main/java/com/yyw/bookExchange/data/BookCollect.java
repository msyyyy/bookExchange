package com.yyw.bookExchange.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
@Table(name = "book_collect")
public class BookCollect {
    @Id
    @GeneratedValue
    private long id;

    @Column
    private long book_id;

    @Column
    private long user_id;

    @Column
    private int status;

    @Column
    private String value;

    @Column
    private int man;

    public int getMan() {
        return man;
    }

    public void setMan(int man) {
        this.man = man;
    }

    @Column
    private long create_time;
    public BookCollect() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getBook_id() {
        return book_id;
    }

    public void setBook_id(long book_id) {
        this.book_id = book_id;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public long getCreate_time() {
        return create_time;
    }

    public void setCreate_time(long create_time) {
        this.create_time = create_time;
    }
}
