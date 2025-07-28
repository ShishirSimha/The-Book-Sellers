package com.booksellers.dtos;

import java.math.BigDecimal;

public record BookDTO(String isbn, String title, String author, 
                      BigDecimal wholesalePrice, BigDecimal retailPrice, 
                      boolean isUsed, int quantityOnHand) {

    public static BookDTO fromEntity(com.booksellers.entities.Book book) {
        return new BookDTO(
            book.getIsbn(),
            book.getTitle(),
            book.getAuthor(),
            book.getWholesalePrice(),
            book.getRetailPrice(),
            book.isUsed(),
            book.getQuantityOnHand()
        );
    }

}
