package com.booksellers.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.booksellers.entities.Book;

public interface BookRepository extends JpaRepository<Book, String> {
    
    /**
     * Find a book by its ISBN.
     * 
     * @param isbn the ISBN of the book
     * @return the book entity if found, otherwise null
     */
    Book findByIsbn(String isbn);
    
    /**
     * Check if a book exists by its ISBN.
     * 
     * @param isbn the ISBN of the book
     * @return true if the book exists, false otherwise
     */
    boolean existsByIsbn(String isbn);

}
