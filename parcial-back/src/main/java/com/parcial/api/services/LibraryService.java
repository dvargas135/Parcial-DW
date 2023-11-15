package com.parcial.api.services;

import org.springframework.stereotype.Service;

import com.parcial.api.model.library.Library;
import com.parcial.api.model.library.LibraryRepository;

@Service
public class LibraryService {
    private final LibraryRepository libraryRepository;

    public LibraryService(LibraryRepository libraryRepository) {
        this.libraryRepository = libraryRepository;
    }

    public LibraryRepository getRepository() {
        return this.libraryRepository;
    }

    public Library getLibraryById(Long libraryId) {
        return libraryRepository.findById(libraryId).orElse(null);
    }

    public void saveLibrary(Library library) {
        libraryRepository.save(library);
    }

    public void updateLibrary(Long libraryId, Library updatedLibrary) {
        Library existingLibrary = libraryRepository.findById(libraryId).orElse(null);

        if (existingLibrary != null) {
            existingLibrary.setName(updatedLibrary.getName());
            existingLibrary.setAddress(updatedLibrary.getAddress());
            existingLibrary.setCity(updatedLibrary.getCity());

            libraryRepository.save(existingLibrary);
        }
    }

    public void deleteLibrary(Long libraryId) {
        libraryRepository.deleteById(libraryId);
    }
}
