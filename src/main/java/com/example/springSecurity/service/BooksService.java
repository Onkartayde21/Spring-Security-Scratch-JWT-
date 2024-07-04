package com.example.springSecurity.service;

import com.example.springSecurity.entity.Books;
import com.example.springSecurity.entity.User;
import com.example.springSecurity.repository.BooksRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class BooksService {

    @Autowired
    private BooksRepo booksRepo;

    @Autowired
    private UserService userService;



//    @Transactional
    public void addBookofUser(Books books, String userName){
        User user = userService.findByUserName(userName);
        Books userBooks=booksRepo.save(books);
        user.getBooks().add(userBooks);
        userService.addUser(user);
    }

    public ArrayList<Books> getAllBooks(){
        ArrayList<Books>booksList = new ArrayList<>();
        booksRepo.findAll().forEach(booksList::add);
        return booksList;
    }

    public Optional<Books> getBook(String id) {
        return booksRepo.findById(id);
    }

    public void deleteBook(String id, String userName){
        User user = userService.findByUserName(userName);
        user.getBooks().removeIf(x -> x.getId().equals(id));
        userService.addUser(user);
        booksRepo.deleteById(id);
    }

    public void updateBookById(Books books){
        booksRepo.save(books);
    }
}
