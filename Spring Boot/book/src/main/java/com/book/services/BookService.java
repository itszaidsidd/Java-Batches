package com.book.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.entity.Book;
import com.book.repository.BookRepository;

@Service 
public class BookService {
    
   @Autowired 
   private BookRepository bookRepository;

   public Book addBook(Book book){
    if (book.getAuthor() != null) {
           book.getAuthor().setBook(book); // Author ko bataya ki uski book kaunsi hai
       }
    return bookRepository.save(book);
   }

   public List<Book> getAllBook(){
    List<Book> list=bookRepository.findAll();
    if(list.isEmpty()){
        return null;
    }
    return list;
   }


}
