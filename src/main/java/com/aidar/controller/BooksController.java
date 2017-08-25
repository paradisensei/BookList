package com.aidar.controller;

import com.aidar.entity.Book;
import com.aidar.entity.User;
import com.aidar.service.BookService;
import com.aidar.service.UserService;
import com.aidar.util.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

import static com.aidar.util.ApplicationUrls.*;

/**
 * @author Aidar Shaifutdinov.
 */
@Controller
public class BooksController {

    private final UserService userService;

    private final BookService bookService;

    @Autowired
    public BooksController(UserService userService, BookService bookService) {
        this.userService = userService;
        this.bookService = bookService;
    }

    @GetMapping(BASE_BOOKS_URL)
    public String getBooks(Model model) {
        User user = SecurityUtils.getPrincipal();
        Collection<Book> books = bookService.getAll();
        Collection<Book> favouriteBooks = userService.getFavouriteBooks(user);
        books.removeAll(favouriteBooks);
        model.addAttribute("books", books);
        return "books/books";
    }

    @GetMapping(MY_BOOKS_URL)
    public String getMyBooks(Model model) {
        User user = SecurityUtils.getPrincipal();
        model.addAttribute("books", userService.getFavouriteBooks(user));
        return "/books/my_books";
    }

    @PostMapping(CRUD_MY_BOOK_URL)
    @ResponseBody
    public void addMyBook(@PathVariable("id") Long id) {
        User user = SecurityUtils.getPrincipal();
        userService.addFavouriteBook(user, id);
    }

    @DeleteMapping(CRUD_MY_BOOK_URL)
    @ResponseBody
    public void removeMyBook(@PathVariable("id") Long id) {
        User user = SecurityUtils.getPrincipal();
        userService.removeFavouriteBook(user, id);
    }

}
