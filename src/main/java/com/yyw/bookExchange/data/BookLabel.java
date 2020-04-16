package com.yyw.bookExchange.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
@Table(name = "book_label")
public class BookLabel {
    @Id
    @GeneratedValue
    private long id;

    @Column
    private long book_id;

    @Column
    private String label_name;

    @Column
    private long num;

    public BookLabel() {
    }

    public long getId() {
        return id;
    }

    public String getLabel_name() {
        return label_name;
    }

    public void setLabel_name(String label_name) {
        this.label_name = label_name;
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


    public long getNum() {
        return num;
    }

    public void setNum(long num) {
        this.num = num;
    }
}
