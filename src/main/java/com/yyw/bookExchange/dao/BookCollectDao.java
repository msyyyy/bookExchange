package com.yyw.bookExchange.dao;

import com.yyw.bookExchange.data.Book;
import com.yyw.bookExchange.data.BookCollect;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookCollectDao extends JpaRepository<BookCollect, Long> {
}
