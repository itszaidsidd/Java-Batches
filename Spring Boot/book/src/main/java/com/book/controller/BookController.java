package com.book.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.book.entity.Book;
import com.book.repository.BookRepository;
import com.book.services.BookService;

@RestController 
@RequestMapping("book")
public class BookController {
    
    @Autowired 
    private BookService bookService;

    @PostMapping 
    public ResponseEntity<Book> addBook(@RequestBody Book book){
        try{
            Book b=bookService.addBook(book);
            return ResponseEntity.of(Optional.of(b));
        }catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping 
    public ResponseEntity<List<Book>> getBooks(){
        try {
            List<Book> list = bookService.getAllBook();
            if(list==null){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
            return ResponseEntity.ok(list);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        
    }

}
