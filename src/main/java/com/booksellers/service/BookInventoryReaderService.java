package com.booksellers.service;

import org.springframework.stereotype.Service;

import com.booksellers.dtos.BookDTO;

@Service
public interface BookInventoryReaderService {

    public BookDTO getBookDetails(String isbn); 
}
