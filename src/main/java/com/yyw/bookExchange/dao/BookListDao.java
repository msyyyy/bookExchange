package com.yyw.bookExchange.dao;


import com.yyw.bookExchange.data.BookList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookListDao extends JpaRepository<BookList, Long> {
}
