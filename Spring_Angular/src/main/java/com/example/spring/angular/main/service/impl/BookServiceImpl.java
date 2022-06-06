package com.example.spring.angular.main.service.impl;

import com.example.spring.angular.main.dao.BookDao;
import com.example.spring.angular.main.model.Book;
import com.example.spring.angular.main.service.interfaces.BookService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.slf4j.Logger;

@Service
public class BookServiceImpl implements BookService {
    private static final Logger LOGGER= LoggerFactory.getLogger(BookServiceImpl.class);
    @Autowired
    public BookDao dao;
    @Override
    public List<Book> getBooks() {
        List<Book> books=new ArrayList<>();
        try {
            books=(List<Book>)this.dao.findAll();
            if(CollectionUtils.isEmpty(books)){
                return new ArrayList<Book>();
            } else {
                return books;
            }
        } catch (Exception e){
            LOGGER.error("Failed to fetch book from backend database",e.getMessage());
        }
        return books;
    }

    @Override
    public Optional<Book> getBook(Long id) {
        Optional<Book> book= Optional.of(new Book());
        try {
            book=(Optional<Book>) this.dao.findById(id);
            if(Objects.nonNull(book)){
                return book;
            } else {
                return Optional.of(new Book());
            }
        } catch (Exception e){
            LOGGER.error("Failed to fetch book from backend database",e.getMessage());
        }
        return book;
    }

    @Override
    public Book addOrUpdateBook(Book book) {
        Book book1= new Book();
        try {
            book1=this.dao.save(book);
            if(Objects.nonNull(book)){
                return book;
            } else {
                return new Book();
            }
        } catch (Exception e){
            LOGGER.error("Failed to save book into the backend database",e.getMessage());
        }
        return book1;
    }

    @Override
    public void delete(Long id) {
        try {
            this.dao.deleteById(id);
        } catch (Exception e){
            LOGGER.error("Failed to remove book from the backend database",e.getMessage());
        }
    }
}
