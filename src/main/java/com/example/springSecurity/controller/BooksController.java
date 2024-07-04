package com.example.springSecurity.controller;

import com.example.springSecurity.entity.Books;
import com.example.springSecurity.entity.User;
import com.example.springSecurity.service.BooksService;
import com.example.springSecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class BooksController {

    @Autowired
    private BooksService booksService;

    @Autowired
    private UserService userService;

    @GetMapping("/books/{userName}")
    public ResponseEntity<?> getAllBooksofUser(@PathVariable String userName){
        User user = userService.findByUserName(userName);
        List<Books> userbooks = user.getBooks();
        if (userbooks != null && !userbooks.isEmpty()){
            return new ResponseEntity<>(userbooks, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/books/{userName}")
    public ResponseEntity<Books> addBooks(@RequestBody Books books,@PathVariable String userName){
        try {
            booksService.addBookofUser(books, userName);
            return new ResponseEntity<>(books, HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/books")
    public ArrayList<Books> getAllBooks(){
        return booksService.getAllBooks();
    }

    @GetMapping("/books/id/{id}")
    public ResponseEntity<Books> getBook(@PathVariable String id){
        Optional<Books> book = booksService.getBook(id);
        if (book.isPresent()){
            return new ResponseEntity<>(book.get(), HttpStatus.OK);

        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/books/id/{userName}/{id}")
    public ResponseEntity<?> deleteBookById(@PathVariable String id,@PathVariable String userName){
        booksService.deleteBook(id, userName);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/books/id/{userName}/{id}")
    public ResponseEntity<?> updateBookById(
            @PathVariable String id,
            @RequestBody Books books,
            @PathVariable String userName
    ) {
        Books oldBook = booksService.getBook(id).orElse(null);
        if (oldBook != null){
            oldBook.setBookName(books.getBookName() != null && !books.getBookName().equals("")?books.getBookName() : oldBook.getBookName());
            oldBook.setBookAuthor(books.getBookAuthor() != null && !books.getBookAuthor().equals("") ? books.getBookAuthor() : oldBook.getBookAuthor());
            oldBook.setBookGenre(books.getBookGenre() != null && !books.getBookGenre().equals("") ? books.getBookGenre() : oldBook.getBookGenre());
            booksService.updateBookById(books);
            return new ResponseEntity<>(oldBook, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
