package com.aidar.service.impl;

import com.aidar.entity.Book;
import com.aidar.entity.User;
import com.aidar.repository.UserRepository;
import com.aidar.service.UserService;
import com.aidar.util.UserRegistrationForm;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;

/**
 * @author Aidar Shaifutdinov.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @PersistenceContext
    private EntityManager entityManager;

    private final UserRepository userRepository;

    private final PasswordEncoder encoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder encoder) {
        this.userRepository = userRepository;
        this.encoder = encoder;
    }

    @Override
    public void add(UserRegistrationForm userForm) {
        User user = new User();
        user.setName(userForm.getName());
        user.setEmail(userForm.getEmail());
        user.setPassword(encoder.encode(userForm.getPassword()));
        userRepository.save(user);
    }

    @Override
    public Collection<Book> getFavouriteBooks(User user) {
        user = entityManager.merge(user);
        Collection<Book> books = user.getFavourites();
        Hibernate.initialize(books);
        return books;
    }

    @Override
    public void addFavouriteBook(User user, Long bookId) {
        entityManager.createNativeQuery(
                "insert into users_books values (:user, :book)")
                .setParameter("user", user.getId())
                .setParameter("book", bookId)
                .executeUpdate();
    }

    @Override
    public void removeFavouriteBook(User user, Long bookId) {
        entityManager.createNativeQuery(
                "delete from users_books where user_id=:user and book_id=:book")
                .setParameter("user", user.getId())
                .setParameter("book", bookId)
                .executeUpdate();
    }

}
