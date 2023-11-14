package com.parcial.api.model.dto;

import com.parcial.api.model.library.Library;

public class LibraryDTO {
    private Long id;
    private String name;
    private String address;
    private String city;

    public LibraryDTO() {
        super();
        this.id = null;
        this.name = null;
        this.address = null;
        this.city = null;
    }

    public LibraryDTO(Long id, String name, String address, String city) {
        super();
        this.id = id;
        this.name = name;
        this.address = address;
        this.city = city;
    }

    public LibraryDTO(Library library) {
        this.id = library.getId();
        this.name = library.getName();
        this.address = library.getAddress();
        this.city = library.getCity();
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
