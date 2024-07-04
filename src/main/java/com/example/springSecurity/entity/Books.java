package com.example.springSecurity.entity;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;


@Document(collection = "books")
@Data
@NoArgsConstructor
public class Books {

    @MongoId
    private String id;

    private String bookName;

    private String bookGenre;

    private String bookAuthor;

    /*public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookGenre() {
        return bookGenre;
    }

    public void setBookGenre(String bookGenre) {
        this.bookGenre = bookGenre;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public Books(String id, String bookName, String bookGenre, String bookAuthor) {
        this.id = id;
        this.bookName = bookName;
        this.bookGenre = bookGenre;
        this.bookAuthor = bookAuthor;
    }

    public Books() {
    }

    @Override
    public String toString() {
        return "Books{" +
                "id=" + id +
                ", bookName='" + bookName + '\'' +
                ", bookGenre='" + bookGenre + '\'' +
                ", bookAuthor='" + bookAuthor + '\'' +
                '}';
    }
*/

}
