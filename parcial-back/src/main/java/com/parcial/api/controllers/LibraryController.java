package com.parcial.api.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.parcial.api.model.dto.LibraryDTO;
import com.parcial.api.model.library.Library;
import com.parcial.api.services.LibraryService;

@RestController
public class LibraryController {

    @Autowired
    private final LibraryService libraryService;

    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @CrossOrigin
    @GetMapping(value = "/libraries", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<LibraryDTO>> getAllLibraries() {
        try {
            List<Library> libraries = (List<Library>) libraryService.getRepository().findAll();
            
            List<LibraryDTO> libraryDTOs = libraries.stream()
                    .map(LibraryDTO::new)
                    .collect(Collectors.toList());

            return new ResponseEntity<>(libraryDTOs, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @CrossOrigin
    @GetMapping("/libraries/{libraryId}")
    public ResponseEntity<LibraryDTO> getLibraryById(@PathVariable Long libraryId) {
        Library library = libraryService.getLibraryById(libraryId);

        if (library != null) {
            LibraryDTO libraryDTO = new LibraryDTO(library);
            return new ResponseEntity<>(libraryDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @CrossOrigin
    @PostMapping(value = "/libraries/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LibraryDTO> createLibrary(@RequestBody LibraryDTO libraryDTO) {
        Library newLibrary = convertToEntity(libraryDTO);
        libraryService.saveLibrary(newLibrary);

        return new ResponseEntity<>(new LibraryDTO(newLibrary), HttpStatus.CREATED);
    }

    @CrossOrigin
    @PutMapping("/libraries/{libraryId}")
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

    @CrossOrigin
    @DeleteMapping("/libraries/{libraryId}")
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
