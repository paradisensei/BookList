package com.aidar.service;

import com.aidar.entity.Book;
import com.aidar.entity.User;
import com.aidar.util.UserRegistrationForm;

import java.util.Collection;

/**
 * @author Aidar Shaifutdinov.
 */
public interface UserService {

    void add(UserRegistrationForm userForm);

    Collection<Book> getFavouriteBooks(User user);

    void addFavouriteBook(User user, Long bookId);

    void removeFavouriteBook(User user, Long bookId);

}
