package com.example.resttest.repositories;

import com.example.resttest.models.Book;

import java.util.ArrayList;
import java.util.List;

public class DataBaseSimulator {

    public List<Book> getAllBooks(){
        List<Book> bookList = new ArrayList<>();
        Book book1= new Book("Taper och solsken", "danne B", 1);
        Book book2 = new Book("Arde", "arde2", 2);
        Book book3 = new Book("Daggista", "neymar", 3);
        bookList.add(book1);
        bookList.add(book2);
        bookList.add(book3);

        return bookList;
    }
}
