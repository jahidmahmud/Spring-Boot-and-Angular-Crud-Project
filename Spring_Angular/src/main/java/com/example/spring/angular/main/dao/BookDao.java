package com.example.spring.angular.main.dao;

import com.example.spring.angular.main.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookDao extends JpaRepository<Book,Long> {
}
