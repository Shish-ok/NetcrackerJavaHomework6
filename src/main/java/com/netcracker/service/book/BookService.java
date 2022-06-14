package com.netcracker.service.book;

import com.netcracker.dto.books.NameAndPriceBookDto;
import com.netcracker.dto.books.UpdateBookDto;
import com.netcracker.dto.books.WordAndPriceDto;
import com.netcracker.model.Book;

import java.util.List;

public interface BookService {

    List<Book> getAllBooks();

    Book getBookById(int bookId);

    Book saveBook(Book book);

    String updateBook(int bookId, UpdateBookDto updateBookDto);

    String fullUpdateBook(int bookId, UpdateBookDto updateBookDto);

    String deleteBook(int bookId);

    List<NameAndPriceBookDto> getPriceList();

    List<NameAndPriceBookDto> getCustomPriceList(WordAndPriceDto wordAndPriceDto);

}