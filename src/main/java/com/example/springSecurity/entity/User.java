package com.example.springSecurity.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "users")
@Data
@NoArgsConstructor
public class User {

    @Id
    private String id;
    @NonNull
    @Indexed(unique = true )//to create this index automatically-> go to properties
    private String userName;
    @NonNull
    private String password;
    @DBRef
    private List<Books> books= new ArrayList<>();
    private List<String> roles;

}
