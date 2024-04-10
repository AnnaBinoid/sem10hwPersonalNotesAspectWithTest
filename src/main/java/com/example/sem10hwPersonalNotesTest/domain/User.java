package com.example.sem10hwPersonalNotesTest.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Класс пользователя с id, именем.
 * id пользователя генерируется автоматически.
 * Имя передается в конструктор.
 */
@Data
@Entity
@NoArgsConstructor
@Table(name= "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userID;

    private String userName;

    private User(Builder builder) {
        this.userName = builder.name;
    }

    public static class Builder {
        private String name;

        public Builder(String name) {
            this.name = name;
        }

        public User build() {
            return new User(this);
        }
    }

}
