package com.yyw.bookExchange.dao;

import com.yyw.bookExchange.data.Book;
import com.yyw.bookExchange.data.BookLabel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookLabelDao extends JpaRepository<BookLabel, Long> {
}
