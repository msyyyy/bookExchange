package com.yyw.bookExchange.dao;

import com.yyw.bookExchange.data.Book;
import com.yyw.bookExchange.data.BookLove;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookLoveDao extends JpaRepository<BookLove, Long> {
}
