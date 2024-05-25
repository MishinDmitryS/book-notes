package com.dm.bookwithnotes.repositories;

import com.dm.bookwithnotes.models.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface NoteRepository extends CrudRepository<Note, Long> {
    List<Note> findByTitle(String title);
}
