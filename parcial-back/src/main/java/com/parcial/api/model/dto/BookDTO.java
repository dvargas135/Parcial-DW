package com.parcial.api.model.dto;

import com.parcial.api.model.book.Book;

public class BookDTO {
    private Long id;
    private String name;
    private String author;
    private LibraryDTO library;

    public BookDTO() {
        super();
        this.id = null;
        this.name = null;
        this.author = null;
        this.library = null;
    }

    public BookDTO(Long id, String name, String author, LibraryDTO library) {
        super();
        this.id = id;
        this.name = name;
        this.author = author;
        this.library = library;
    }

    public BookDTO(Book book) {
        this.id = book.getId();
        this.name = book.getName();
        this.author = book.getAuthor();
        
        if (book.getLibrary() != null) {
            this.library = new LibraryDTO(book.getLibrary());
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LibraryDTO getLibrary() {
        return library;
    }

    public void setLibrary(LibraryDTO library) {
        this.library = library;
    }
}
