package com.api.book.bootrestbook.services;

import java.util.*;
import java.util.stream.Collectors;

import com.api.book.bootrestbook.entities.Book;

import org.springframework.stereotype.Component;

@Component
public class BookService {
    private static List<Book> list=new ArrayList<>();
    static{
        list.add(new Book(22,"Java Complete Referance","Dipak"));
        list.add(new Book(5,"JavaScript Complete Referance","Hridhi"));
        list.add(new Book(50,"Dot net Complete Referance","Sachin"));
    }

    //get all books
    public List<Book> getAllBooks(){
        return list;
    }

    //get single book by id
    public Book getBookById(int id){
        Book book=null;
        try{
            book = list.stream().filter(e->e.getId()==id).findFirst().get();
        }catch(Exception e){
            e.printStackTrace();
        }
        return book;
    }

    //add book
    public Book addBook(Book b){
        list.add(b);
        return b;
    }

    //Delete book
    public void deleteBook(int bid){
        list = list.stream().filter(book->book.getId()!=bid).collect(Collectors.toList());
    }

    //Update Book
    public void updateBook(Book book,int bookId){
        list = list.stream().map(b->{
            if(b.getId()==bookId){
                b.setTitle(book.getTitle());
                b.setAuthor(book.getAuthor());
            }
            return b;
        }).collect(Collectors.toList());
    }
}
