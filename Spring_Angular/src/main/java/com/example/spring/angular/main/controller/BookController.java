package com.example.spring.angular.main.controller;

import com.example.spring.angular.main.model.Book;
import com.example.spring.angular.main.service.interfaces.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@CrossOrigin("http://localhost:40735")
@RequestMapping("/api")
public class BookController {
    private static final Logger LOGGER= LoggerFactory.getLogger(BookController.class);
    @Autowired
    private BookService service;
    @GetMapping(path = "/books")
    public ResponseEntity<List<Book>> getBooks() {
        List<Book> books =new ArrayList<>();
        try {
            books = this.service.getBooks();
            if(CollectionUtils.isEmpty(books)) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
            return ResponseEntity.ok().body(books);
        } catch (Exception e){
            LOGGER.error("Failed to fetch book from backend",e.getMessage());
        }
        return ResponseEntity.ok(books);
    }
    @GetMapping(path = "/books/{id}")
    public ResponseEntity<Optional<Book>> getBookById(@PathVariable("id") Long id){
        Optional<Book> book =Optional.of(new Book());
        try {
            book = this.service.getBook(id);
            if(Objects.nonNull(book)) {
                return ResponseEntity.ok().body(book);
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception e){
            LOGGER.error("Failed to fetch single book from backend",e.getMessage());
        }
        return ResponseEntity.unprocessableEntity().build();
    }
    @PostMapping(path = "/books",consumes ="application/json")
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        Book book1=new Book();
        try {
            book1 = service.addOrUpdateBook(book);
            if (Objects.nonNull(book1)){
                return ResponseEntity.status(HttpStatus.CREATED).body(book1);
            }
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

        } catch (Exception e) {
            LOGGER.error("Failed to insert book into backend",e.getMessage());
        }
        return ResponseEntity.unprocessableEntity().body(book);
    }
    @PutMapping (path = "/books",consumes ="application/json")
    public ResponseEntity<Book> updateBook(@RequestBody Book book) {
        Book book1=new Book();
        try {
            book1 = service.addOrUpdateBook(book);
            if (Objects.nonNull(book1)){
                return ResponseEntity.status(HttpStatus.OK).body(book1);
            }
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

        } catch (Exception e) {
            LOGGER.error("Failed to update book in backend",e.getMessage());
        }
        return ResponseEntity.unprocessableEntity().body(book);
    }
    @DeleteMapping(path = "/books/{id}")
    public ResponseEntity<HttpStatus> deleteBook(@PathVariable("id") Long id){
        try {
            this.service.delete(id);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception e) {
            LOGGER.error("Failed to delete book from backend",e.getMessage());
        }
        return ResponseEntity.unprocessableEntity().build();
    }
}
