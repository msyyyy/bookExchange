package com.yyw.bookExchange.dao;

import com.yyw.bookExchange.data.Text;
import com.yyw.bookExchange.data.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentDao extends JpaRepository<Text, Long> {
}
