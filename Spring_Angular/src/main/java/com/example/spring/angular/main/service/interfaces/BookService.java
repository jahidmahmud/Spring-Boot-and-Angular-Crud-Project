package com.example.spring.angular.main.service.interfaces;

import com.example.spring.angular.main.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {
    public List<Book> getBooks();
    public Optional<Book> getBook(Long id);
    public Book addOrUpdateBook(Book book);
    public void delete(Long id);
}
