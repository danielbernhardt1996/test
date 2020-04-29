package com.example.resttest.Controllers;

import com.example.resttest.repositories.DataBaseSimulator;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.resttest.models.Book;

import java.util.ArrayList;
import java.util.List;

@RestController // kan ta emot web request
public class BookController {


    Book book;

    DataBaseSimulator dataBaseSimulator;
    List<Book> bookList;

    public BookController() {
        dataBaseSimulator = new DataBaseSimulator();
        bookList = dataBaseSimulator.getAllBooks();
    }

    @RequestMapping(value = "/booksjson", produces = "application/json")
    public Book oneBookJSON() {
        return new Book("Solsken", "Danne", 1);
    }

    @RequestMapping(value = "/booksxml",produces = "application/xml")
    public Book oneBookXML() {
        return new Book("Arde", "ARdee", 2);
    }

    @RequestMapping(value = "/books",produces = "application/xml")
    public List<Book> allBook(){
        return bookList;
    }


    @RequestMapping(value = "/book/{id}",produces = "application/json")
    public Book getBookById(@PathVariable int id){
        Book res = null;
        for (Book book: bookList
             ) {
            if (book.getId()==id)
                res=book;
        }
        return res;
    }

    @RequestMapping(value = "/booksbetween/{idFrom}/{idTo}", produces = "application/json")
    public List<Book> getBooksBetween(@PathVariable int idFrom, @PathVariable int idTo){
        List<Book> res=new ArrayList<>();
        for (Book b: bookList
             ) {
            int id=b.getId();
            if (id>=idFrom && id <= idTo){
                res.add(b);
            }
        }

        return res;
    }

}


