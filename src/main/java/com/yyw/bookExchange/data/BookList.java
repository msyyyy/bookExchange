package com.yyw.bookExchange.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
@Table(name = "book_list")
public class BookList {
    @Id
    @GeneratedValue
    private long id;

    @Column
    private long user_id;

    @Column
    private String list_name;

    @Column
    private String brief_msg;


    public BookList(){

    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public String getList_name() {
        return list_name;
    }

    public void setList_name(String list_name) {
        this.list_name = list_name;
    }

    public String getBrief_msg() {
        return brief_msg;
    }

    public void setBrief_msg(String brief_msg) {
        this.brief_msg = brief_msg;
    }
}
