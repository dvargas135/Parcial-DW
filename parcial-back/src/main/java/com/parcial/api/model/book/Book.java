package com.parcial.api.model.book;

import java.util.Iterator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.amazonaws.util.json.JSONArray;
import com.amazonaws.util.json.JSONObject;
import com.parcial.api.model.library.Library;

@Entity
public class Book {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String author;

    @OneToOne
    @JoinColumn(name = "library_id")
    private Library library;

    public Book() {
        super();
        this.id = null;
        this.name = null;
        this.author = null;
        this.library = null;
    }

    public Book(Long id, String name, String author, Library library) {
        super();
        this.id = id;
        this.name = name;
        this.author = author;
        this.library = library;
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

    
    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }

    public JSONObject toJSON() throws Exception {
        JSONObject japplication = new JSONObject();
        japplication.put("id", getId());
        japplication.put("name", getName());
        japplication.put("author", getAuthor());
        japplication.put("library", getLibrary());

        return japplication;
    }
    
    public static JSONArray toJSONArray( Iterable<Book> books ) throws Exception {
		JSONArray jbooks = new JSONArray();
        Iterator<Book> ibooks = books.iterator();
        while(ibooks.hasNext()) {
            Book library = ibooks.next();
            jbooks.put(library.toJSON());
        }

        return jbooks;
    }
}
