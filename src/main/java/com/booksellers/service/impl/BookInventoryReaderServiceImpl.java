package com.booksellers.service.impl;

import com.booksellers.dtos.BookDTO;
import com.booksellers.entities.Book;
import com.booksellers.repository.BookRepository;
import com.booksellers.service.BookInventoryReaderService;

public class BookInventoryReaderServiceImpl implements BookInventoryReaderService {

    private final BookRepository bookRepository;

    public BookInventoryReaderServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public BookDTO getBookDetails(String isbn) {
        Book book;
        if(isbn == null || isbn.isEmpty()) {
            throw new IllegalArgumentException("ISBN cannot be null or empty");
        }

        if(bookRepository.existsByIsbn(isbn)) {
            book = bookRepository.findByIsbn(isbn);
        } else {
            throw new IllegalArgumentException("Book with ISBN " + isbn + " does not exist");
        }

        return BookDTO.fromEntity(book);
    }

}
