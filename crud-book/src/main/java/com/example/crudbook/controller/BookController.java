package com.example.crudbook.controller;

import com.example.crudbook.dto.BookRequest;
import com.example.crudbook.model.Book;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/book")
public class BookController {
    private Map<String, Book> books ;

    public BookController() {
        books = new HashMap<>();
        books.put("0x-1", new Book("0x-1","Thương Vợ", "Tú Xương", 2000));
        books.put("0x-2", new Book("0x-2","Dế Mèn", "Tô Hoài", 2009));
        books.put("0x-3", new Book("0x-3","Java", "John", 2022));
        books.put("0x-4", new Book("0x-4","Hóa học", "Thanh Thảo", 2020));
        books.put("0x-5", new Book("0x-5","Lịch Sử", "Nguyên", 2008));
        books.put("0x-6", new Book("0x-6","Tin học", "Nam Tú", 2021));


    }

    @GetMapping("/get-all-book")
    public ResponseEntity<Object> getBook(@RequestParam String name) {
        return new ResponseEntity<>(books.values().stream().toList(),HttpStatus.OK);
    }


    @PostMapping("/post-book")
    public Book createNewBook(@RequestBody BookRequest bookRequest){
        String id = UUID.randomUUID().toString();
        Book book = new Book();
        book.setId(id);
        book.setTitle(bookRequest.getTitle());
        book.setAuthor(bookRequest.getAuthor());
        book.setYear(bookRequest.getYear());
        return book;
    }

    @GetMapping(value = "/{id}")
    public Book getBookId(@PathVariable("id") String id ){
        return books.get(id);
    }
    @PutMapping(value = "/{id}")
    public Book updateBookById(@PathVariable("id") String id, @RequestBody BookRequest bookRequest){
        Book updateBook = new Book(id, bookRequest.getTitle(), bookRequest.getAuthor(), bookRequest.getYear());
        books.put(id, updateBook);
        return updateBook;
    }

    @DeleteMapping(value = "/{id}")
    public Book deleteBookById(@PathVariable("id") String id){
        Book removedBook = books.remove(id);
        return removedBook;
    }
}
