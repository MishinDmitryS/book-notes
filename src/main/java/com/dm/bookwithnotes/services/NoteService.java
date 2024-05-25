package com.dm.bookwithnotes.services;

import com.dm.bookwithnotes.models.Note;
import com.dm.bookwithnotes.repositories.NoteRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class NoteService {
    private final NoteRepository noteRepository;

    public Iterable<Note> noteList(String title) {
        if (title != null) return noteRepository.findByTitle(title);
        return noteRepository.findAll();
    }

    public void saveNote(Note note) {
        log.info("Saving note: {}", note.getTitle());
        noteRepository.save(note);
    }

    public void deleteNote(Long id) {
        noteRepository.deleteById(id);
    }

    public Note getNoteById(Long id) {
        return noteRepository.findById(id).orElse(null);
    }

}
