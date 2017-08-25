package com.aidar.util;

/**
 * @author Aidar Shaifutdinov.
 */
public interface ApplicationUrls {

    String SIGN_UP_URL = "/";

    String LOGIN_URL = "/login";

    String BASE_BOOKS_URL = "/books";

    String MY_BOOKS_URL = BASE_BOOKS_URL + "/my";

    String CRUD_MY_BOOK_URL = MY_BOOKS_URL + "/{id}";

}
