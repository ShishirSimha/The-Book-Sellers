package com.booksellers.entities;

import java.math.BigDecimal;
import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Entity
public class Book {
    @Id
    @UuidGenerator
    private String id;
    private String isbn;
    private String title;
    private String author;
    private BigDecimal wholesalePrice;
    private BigDecimal retailPrice;
    private boolean isUsed;
    private int quantityOnHand;
}
