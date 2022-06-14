package com.netcracker.service.book;

import com.netcracker.dto.books.NameAndPriceBookDto;
import com.netcracker.dto.books.UpdateBookDto;
import com.netcracker.dto.books.WordAndPriceDto;
import com.netcracker.exception.ResourceNotFoundException;
import com.netcracker.model.Book;
import com.netcracker.response.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private Book book;

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBookById(int bookId) {
        return bookRepository.findById(bookId).orElseThrow(() -> new ResourceNotFoundException("Not found book with id: " + bookId));
    }

    @Override
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public String updateBook(int bookId, UpdateBookDto updateBookDto) {

        book = bookRepository.findById(bookId).orElseThrow(() -> new ResourceNotFoundException("Not found book with id: " + bookId));

        StringBuilder updateMessage = new StringBuilder();

        if (updateBookDto.getName() != null) {
            bookRepository.updateNameById(updateBookDto.getName(), bookId);
            updateMessage.append("Name successfully updated: old name \"" + book.getName() + "\", new name \"" + updateBookDto.getName() + "\"\n");
        }

        if (updateBookDto.getPrice() != null) {
            bookRepository.updatePriceById(updateBookDto.getPrice(), bookId);
            updateMessage.append("Price successfully updated: old price " + book.getPrice() + ", new price " + updateBookDto.getPrice() + "\n");
        }

        if (updateBookDto.getWarehouse() != null) {
            bookRepository.updateWarehouseById(updateBookDto.getWarehouse(), bookId);
            updateMessage.append("Warehouse successfully updated: old warehouse \"" + book.getWarehouse() + "\", new warehouse \"" + updateBookDto.getWarehouse() + "\"\n");
        }

        if (updateBookDto.getCount() != null) {
            bookRepository.updateCountById(updateBookDto.getCount(), bookId);
            updateMessage.append("Count successfully updated: old count " + book.getCount() + ", new count " + updateBookDto.getCount());
        }

        return updateMessage.toString();
    }

    @Override
    public String fullUpdateBook(int bookId, UpdateBookDto updateBookDto) {
        book = bookRepository.findById(bookId).orElseThrow(() -> new ResourceNotFoundException("Not found book with id: " + bookId));

        book.setName(updateBookDto.getName());
        book.setPrice(updateBookDto.getPrice());
        book.setWarehouse(updateBookDto.getWarehouse());
        book.setCount(updateBookDto.getCount());

        return "Book with id: " + bookId + " — successfully update!";
    }

    @Override
    public String deleteBook(int bookId) {
        book = bookRepository.findById(bookId).orElseThrow(() -> new ResourceNotFoundException("Not found book with id: " + bookId));
        bookRepository.deleteById(bookId);
        return "Book \"" + book.getName() + "\" (id:" + bookId + ") — successfully deleted!";
    }

    @Override
    public List<NameAndPriceBookDto> getPriceList() {
        return bookRepository.getAllNameAndPrice();
    }

    @Override
    public List<NameAndPriceBookDto> getCustomPriceList(WordAndPriceDto wordAndPriceDto) {
        return bookRepository.findBooksByWordOrMoreThenPrice(wordAndPriceDto.getWord(), wordAndPriceDto.getPrice());
    }
}
