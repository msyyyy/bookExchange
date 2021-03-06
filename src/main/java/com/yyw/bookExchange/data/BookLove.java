package com.yyw.bookExchange.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
@Table(name = "book_love")
public class BookLove {
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
    private long create_time;

    public BookLove() {

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

    public long getCreate_time() {
        return create_time;
    }

    public void setCreate_time(long create_time) {
        this.create_time = create_time;
    }

    @Override
    public String toString() {
        return "BookLove{" +
                "id=" + id +
                ", book_id=" + book_id +
                ", user_id=" + user_id +
                ", status=" + status +
                ", create_time=" + create_time +
                '}';
    }
}
