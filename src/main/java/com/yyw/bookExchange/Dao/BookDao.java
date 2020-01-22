package com.yyw.bookExchange.Dao;

import com.yyw.bookExchange.data.Book;
import com.yyw.bookExchange.data.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookDao extends JpaRepository<Book, Long> {

}
