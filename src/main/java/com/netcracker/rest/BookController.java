package com.netcracker.rest;

import com.netcracker.dto.books.NameAndPriceBookDto;
import com.netcracker.dto.books.UpdateBookDto;
import com.netcracker.dto.books.WordAndPriceDto;
import com.netcracker.model.Book;
import com.netcracker.service.book.BookService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books/")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @Operation(summary = "Full book update by id")
    @PutMapping("full_update/{id}")
    public ResponseEntity<String> fullUpdateBook(@PathVariable(value = "id") int id, @RequestBody UpdateBookDto updateBookDto) {
        return ResponseEntity.ok(bookService.fullUpdateBook(id, updateBookDto));
    }

    @Operation(summary = "Partial book update by id")
    @PatchMapping("update/{id}")
    public ResponseEntity<String> updateBook(@PathVariable(value = "id") int id, @RequestBody UpdateBookDto updateBookDto) {
        return ResponseEntity.ok(bookService.updateBook(id, updateBookDto));
    }

    @Operation(summary = "Add new book")
    @PostMapping("add")
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        return ResponseEntity.ok(bookService.saveBook(book));
    }

    @Operation(summary = "Get all books")
    @GetMapping("all")
    public ResponseEntity<List<Book>> getAllBooks() {
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    @Operation(summary = "Get book by id")
    @GetMapping("{id}")
    public ResponseEntity<Book> getBookById(@PathVariable(value = "id") int id) {
        return ResponseEntity.ok(bookService.getBookById(id));
    }

    @Operation(summary = "Delete book by id")
    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable(value = "id") int id) {
        return ResponseEntity.ok(bookService.deleteBook(id));
    }

    @Operation(summary = "Get name and price of all books")
    @GetMapping("price_list")
    public ResponseEntity<List<NameAndPriceBookDto>> getPriceList() {
        return ResponseEntity.ok(bookService.getPriceList());
    }

    @Operation(summary = "Books with the word in the title or more expensive than a certain price")
    @GetMapping("custom_price_list")
    public ResponseEntity<List<NameAndPriceBookDto>> getCustomPriceList(@RequestBody WordAndPriceDto wordAndPriceDto) {
        return ResponseEntity.ok(bookService.getCustomPriceList(wordAndPriceDto));
    }
}