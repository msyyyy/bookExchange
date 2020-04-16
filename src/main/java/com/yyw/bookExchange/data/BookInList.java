package com.yyw.bookExchange.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
@Table(name = "book_in_list")
public class BookInList {
    @Id
    @GeneratedValue
    private long id;

    @Column
    private String list_name;

    @Column
    private long book_id;



    public BookInList(){

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getList_name() {
        return list_name;
    }

    public void setList_name(String list_name) {
        this.list_name = list_name;
    }

    public long getBook_id() {
        return book_id;
    }

    public void setBook_id(long book_id) {
        this.book_id = book_id;
    }

}
