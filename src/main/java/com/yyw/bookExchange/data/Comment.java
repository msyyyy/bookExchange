package com.yyw.bookExchange.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "comment")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Comment {
    @Id
    @GeneratedValue
    long id;

    public Comment() {
    }

    @Column
    private
    long book_id;
    @Column
    private
    long userid;
    @Column
    private
    String content;
    @Column
    private
    String time;
    @Column
    private int agreeNum;

    @Column
    private int disagreeNum;

    public int getAgreeNum() {
        return agreeNum;
    }

    public void setAgreeNum(int agreeNum) {
        this.agreeNum = agreeNum;
    }

    public int getDisagreeNum() {
        return disagreeNum;
    }

    public void setDisagreeNum(int disagreeNum) {
        this.disagreeNum = disagreeNum;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public long getParent() {
        return parent;
    }

    public void setParent(long parent) {
        this.parent = parent;
    }

    @Column
    long parent;

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

    public void setUserid(long userid) {
        this.userid = userid;
    }

    public long getUserid() {
        return userid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
