package com.parcial.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.parcial.api.model.book.Book;
import com.parcial.api.model.dto.BookDTO;
import com.parcial.api.model.library.Library;
import com.parcial.api.services.BookService;

@RestController
public class BookController {
    @Autowired
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @CrossOrigin
    @GetMapping(value = "/books", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getAllAdmins() throws Exception {
        List<Book> books = (List<Book>) bookService.getRepository().findAll();
        HttpHeaders responseHeaders = new HttpHeaders();
        return new ResponseEntity<>(Book.toJSONArray(books).toString(), responseHeaders, HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping("/books/{bookId}")
    public ResponseEntity<BookDTO> getBookById(@PathVariable Long bookId) {
        Book book = bookService.getBookById(bookId);

        if (book != null) {
            BookDTO bookDTO = new BookDTO(book);
            return new ResponseEntity<>(bookDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @CrossOrigin
    @PostMapping(value = "/books/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BookDTO> createBook(@RequestBody BookDTO bookDTO) {
        Book newBook = convertToEntity(bookDTO);
        bookService.saveBook(newBook);

        return new ResponseEntity<>(new BookDTO(newBook), HttpStatus.CREATED);
    }

    @CrossOrigin
    @PutMapping("/books/{bookId}")
    public ResponseEntity<BookDTO> updateBook(
            @PathVariable Long bookId,
            @RequestBody BookDTO updatedBookDTO
    ) {
        Book existingBook = bookService.getBookById(bookId);

        if (existingBook != null) {
            existingBook.setName(updatedBookDTO.getName());
            existingBook.setAuthor(updatedBookDTO.getAuthor());

            bookService.saveBook(existingBook);

            return new ResponseEntity<>(new BookDTO(existingBook), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @CrossOrigin
    @DeleteMapping("/books/{bookId}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long bookId) {
        Book existingBook = bookService.getBookById(bookId);

        if (existingBook != null) {
            bookService.deleteBook(bookId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    private Book convertToEntity(BookDTO bookDTO) {
        Book book = new Book();
        book.setName(bookDTO.getName());
        book.setAuthor(bookDTO.getAuthor());

        if (bookDTO.getLibrary() != null) {
            Library library = new Library();
            library.setName(bookDTO.getLibrary().getName());
            library.setAddress(bookDTO.getLibrary().getAddress());
            library.setCity(bookDTO.getLibrary().getCity());
            book.setLibrary(library);
        }

        return book;
    }
}
