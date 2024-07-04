package com.example.springSecurity.repository;

import com.example.springSecurity.entity.Books;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BooksRepo extends MongoRepository<Books, String> {
}
