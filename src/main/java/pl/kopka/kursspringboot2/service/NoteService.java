package pl.kopka.kursspringboot2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.kopka.kursspringboot2.model.Note;
import pl.kopka.kursspringboot2.repository.NoteRepo;

import java.util.List;
import java.util.Optional;

@Service
public class NoteService {

    private NoteRepo noteRepo;

    @Autowired
    public NoteService(NoteRepo noteRepo){
        this.noteRepo = noteRepo;
    }


    public List<Note> getAllNotes() {
        return noteRepo.findAll();
    }

    public Note addNewNote(Note note) {
        return noteRepo.save(note);
    }

    public Note updateNote(Long id, Note note) {
        Optional<Note> oldNote = noteRepo.findById(id);
        if(oldNote.isPresent()){
            note.setId(id);
            return noteRepo.save(note);
        }
        return null;
    }

    public void deleteNote(Long id) {
        noteRepo.deleteById(id);
    }

    public Optional<Note> getNote(Long id) {
        return noteRepo.findById(id);
    }
}
