package com.aidar.repository;

import com.aidar.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Aidar Shaifutdinov.
 */
@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
