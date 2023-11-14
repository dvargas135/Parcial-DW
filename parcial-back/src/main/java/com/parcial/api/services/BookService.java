package com.parcial.api.services;

import org.springframework.stereotype.Service;

import com.parcial.api.model.book.Book;
import com.parcial.api.model.book.BookRepository;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public BookRepository getRepository() {
        return this.bookRepository;
    }

    public Book getBookById(Long bookId) {
        return bookRepository.findById(bookId).orElse(null);
    }

    public void saveBook(Book book) {
        bookRepository.save(book);
    }

    public void updateBook(Long bookId, Book updatedBook) {
        Book existingBook = bookRepository.findById(bookId).orElse(null);

        if (existingBook != null) {
            existingBook.setName(updatedBook.getName());
            existingBook.setAuthor(updatedBook.getAuthor());
            existingBook.setLibrary(updatedBook.getLibrary());

            bookRepository.save(existingBook);
        }
    }

    public void deleteBook(Long bookId) {
        bookRepository.deleteById(bookId);
    }
}
