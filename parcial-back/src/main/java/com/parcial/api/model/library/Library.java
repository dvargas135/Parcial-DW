package com.parcial.api.model.library;

import java.util.Iterator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.amazonaws.util.json.JSONArray;
import com.amazonaws.util.json.JSONObject;

@Entity
public class Library {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String address;
    private String city;

    public Library() {
        super();
        this.id = null;
        this.name = null;
        this.address = null;
        this.city = null;
    }

    public Library(Long id, String name, String address, String city) {
        super();
        this.id = id;
        this.name = name;
        this.address = address;
        this.city = city;
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

    public JSONObject toJSON() throws Exception {
        JSONObject japplication = new JSONObject();
        japplication.put("id", getId());
        japplication.put("name", getName());
        japplication.put("address", getAddress());
        japplication.put("city", getCity());

        return japplication;
    }
    
    public static JSONArray toJSONArray( Iterable<Library> libraries ) throws Exception {
		JSONArray jlibraries = new JSONArray();
        Iterator<Library> ilibraries = libraries.iterator();
        while(ilibraries.hasNext()) {
            Library library = ilibraries.next();
            jlibraries.put(library.toJSON());
        }

        return jlibraries;
    }
    
}
