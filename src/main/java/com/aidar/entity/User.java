package com.aidar.entity;

import javax.persistence.*;
import java.util.Set;

/**
 * @author Aidar Shaifutdinov.
 */
@Entity
@Table(name = "users")
@SequenceGenerator(name = "users_gen", sequenceName = "users_seq", allocationSize = 1)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_gen")
    private long id;

    private String name;

    private String email;

    private String password;

    @ManyToMany
    @JoinTable(name = "users_books", inverseJoinColumns = @JoinColumn(name = "book_id"))
    private Set<Book> favourites;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Book> getFavourites() {
        return favourites;
    }

    public void setFavourites(Set<Book> favourites) {
        this.favourites = favourites;
    }

    public void addToFavourites(Book book) {
        favourites.add(book);
    }

    public void removeFromFavourites(Book book) {
        favourites.remove(book);
    }

}
