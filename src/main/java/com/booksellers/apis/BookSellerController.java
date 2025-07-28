package com.booksellers.apis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.booksellers.dtos.BookDTO;
import com.booksellers.service.BookInventoryReaderService;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/booksellers")
public class BookSellerController {
    
    @Autowired
    private BookInventoryReaderService readerService;

    /**
     * API: Get book details
     * Purpose: Retrieve book details by ISBN
     * Parameters: ISBN (String)
     * Preconditions: Valid ISBN
     * Postconditions: None
     * Return: BookDTO with book details
     */
    @GetMapping("/get-book/{isbn}")
    public ResponseEntity<BookDTO> getMethodName(@RequestParam String isbn) {
        return ResponseEntity.ok(readerService.getBookDetails(isbn));
    }
    

    /**
     * API: Order new textbooks
     * Purpose: Create or update textbook order in the system
     * Parameters: TextbookOrderDTO (isbn, title, author, wholesalePrice, quantity)
     * Preconditions: Valid ISBN, non-empty title/author, positive wholesale price
     * Postconditions: Textbook is created/updated in database
     * Return: Textbook entity
     */
    @PostMapping("/order")
    public ResponseEntity<Textbook> orderTextbook(@RequestBody TextbookOrderDTO order) {
        return ResponseEntity.ok(service.orderTextbook(order));
    }

    /**
     * API: Receive textbooks
     * Purpose: Update inventory when textbooks are received
     * Parameters: TextbookReceiveDTO (textbookId, quantityReceived)
     * Preconditions: Valid textbook ID, positive quantity
     * Postconditions: Textbook quantity updated in database
     * Return: Updated Textbook entity
     */
    @PostMapping("/receive")
    public ResponseEntity<Textbook> receiveTextbook(@RequestBody TextbookReceiveDTO receive) {
        return ResponseEntity.ok(service.receiveTextbook(receive));
    }

    /**
     * API: Set retail price
     * Purpose: Set the retail price for a textbook
     * Parameters: textbookId, retailPrice
     * Preconditions: Valid textbook ID, positive retail price
     * Postconditions: Textbook retail price updated
     * Return: Updated Textbook entity
     */
    @PostMapping("/price")
    public ResponseEntity<Textbook> setRetailPrice(@RequestBody TextbookPriceDTO price) {
        return ResponseEntity.ok(service.setRetailPrice(price.getTextbookId(), price.getRetailPrice()));
    }

    /**
     * API: Set used textbook price
     * Purpose: Mark textbook as used and set price to 75% of retail
     * Parameters: textbookId
     * Preconditions: Valid textbook ID, retail price set
     * Postconditions: Textbook marked as used, price updated
     * Return: Updated Textbook entity
     */
    @PostMapping("/{textbookId}/used")
    public ResponseEntity<Textbook> setUsedPrice(@PathVariable Long textbookId) {
        return ResponseEntity.ok(service.setUsedPrice(textbookId));
    }

    /**
     * API: Get quantity on hand
     * Purpose: Retrieve current inventory quantity for a textbook
     * Parameters: textbookId
     * Preconditions: Valid textbook ID
     * Postconditions: None
     * Return: Integer quantity
     */
    @GetMapping("/{textbookId}/quantity")
    public ResponseEntity<Integer> getQuantityOnHand(@PathVariable Long textbookId) {
        return ResponseEntity.ok(service.getQuantityOnHand(textbookId));
    }

    /**
     * API: Record textbook sale
     * Purpose: Record a sale transaction and update inventory
     * Parameters: TextbookSaleReturnDTO (textbookId, quantity)
     * Preconditions: Valid textbook ID, sufficient inventory
     * Postconditions: Inventory reduced, sale recorded
     * Return: TextbookTransaction entity
     */
    @PostMapping("/sale")
    public ResponseEntity<TextbookTransaction> recordSale(@RequestBody TextbookSaleReturnDTO sale) {
        return ResponseEntity.ok(service.recordSale(sale));
    }

    /**
     * API: Record textbook return
     * Purpose: Record a return transaction and update inventory
     * Parameters: TextbookSaleReturnDTO (textbookId, quantity)
     * Preconditions: Valid textbook ID
     * Postconditions: Inventory increased, return recorded
     * Return: TextbookTransaction entity
     */
    @PostMapping("/return")
    public ResponseEntity<TextbookTransaction> recordReturn(@RequestBody TextbookSaleReturnDTO returnDTO) {
        return ResponseEntity.ok(service.recordReturn(returnDTO));
    }
}
