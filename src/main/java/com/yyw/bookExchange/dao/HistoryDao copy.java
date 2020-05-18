package com.yyw.bookExchange.dao;

import com.yyw.bookExchange.data.History;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoryDao extends JpaRepository<History,Long> {
}
