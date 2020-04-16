package com.yyw.bookExchange.dao;

import com.yyw.bookExchange.data.BookInList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookInListDao extends JpaRepository<BookInList, Long> {
}
