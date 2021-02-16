package com.api.book.bootrestbook.services;

import java.util.*;

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
        book = list.stream().filter(e->e.getId()==id).findFirst().get();
        return book;
    }
}
