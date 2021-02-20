package com.api.book.bootrestbook.services;

import java.util.*;

import com.api.book.bootrestbook.dao.BookRepository;
import com.api.book.bootrestbook.entities.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    //get all books
    public List<Book> getAllBooks(){
        List<Book> list=(List<Book>)this.bookRepository.findAll();
        return list;
    }

    //get single book by id
    public Book getBookById(int id){
        Book book=null;
        try{
            book=this.bookRepository.findById(id);
        }catch(Exception e){
            e.printStackTrace();
        }
        return book;
    }

    //add book
    public Book addBook(Book b){
        Book result = bookRepository.save(b);
        return result;
    }

    //Delete book
    public void deleteBook(int bid){
        bookRepository.deleteById(bid);
    }

    //Update Book
    public void updateBook(Book book,int bookId){
        book.setId(bookId);
        bookRepository.save(book);
    }
}
