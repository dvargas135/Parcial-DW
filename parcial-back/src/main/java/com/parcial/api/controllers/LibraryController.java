package com.parcial.api.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.parcial.api.model.dto.LibraryDTO;
import com.parcial.api.model.library.Library;
import com.parcial.api.services.LibraryService;

@RestController
@RequestMapping("/api/libraries")
public class LibraryController {
    private final LibraryService libraryService;

    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @GetMapping("/{libraryId}")
    public ResponseEntity<LibraryDTO> getLibraryById(@PathVariable Long libraryId) {
        Library library = libraryService.getLibraryById(libraryId);

        if (library != null) {
            LibraryDTO libraryDTO = new LibraryDTO(library);
            return new ResponseEntity<>(libraryDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LibraryDTO> createLibrary(@RequestBody LibraryDTO libraryDTO) {
        Library newLibrary = convertToEntity(libraryDTO);
        libraryService.saveLibrary(newLibrary);

        return new ResponseEntity<>(new LibraryDTO(newLibrary), HttpStatus.CREATED);
    }

    @PutMapping("/{libraryId}")
    public ResponseEntity<LibraryDTO> updateLibrary(
            @PathVariable Long libraryId,
            @RequestBody LibraryDTO updatedLibraryDTO
    ) {
        Library existingLibrary = libraryService.getLibraryById(libraryId);

        if (existingLibrary != null) {
            existingLibrary.setName(updatedLibraryDTO.getName());
            existingLibrary.setAddress(updatedLibraryDTO.getAddress());
            existingLibrary.setCity(updatedLibraryDTO.getCity());

            libraryService.saveLibrary(existingLibrary);

            return new ResponseEntity<>(new LibraryDTO(existingLibrary), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{libraryId}")
    public ResponseEntity<Void> deleteLibrary(@PathVariable Long libraryId) {
        Library existingLibrary = libraryService.getLibraryById(libraryId);

        if (existingLibrary != null) {
            libraryService.deleteLibrary(libraryId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    private Library convertToEntity(LibraryDTO libraryDTO) {
        Library library = new Library();
        library.setName(libraryDTO.getName());
        library.setAddress(libraryDTO.getAddress());
        library.setCity(libraryDTO.getCity());
        return library;
    }
}
