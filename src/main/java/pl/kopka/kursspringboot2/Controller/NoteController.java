package pl.kopka.kursspringboot2.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.kopka.kursspringboot2.Model.Note;
import pl.kopka.kursspringboot2.Service.NoteService;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/note")
@CrossOrigin
public class NoteController {

    private NoteService noteService;

    @Autowired
    public NoteController(NoteService noteService){
        this.noteService = noteService;
    }

    @GetMapping
    public ResponseEntity<List<Note>> getAllNotes(){
        return new ResponseEntity<>(noteService.getAllNotes(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Note> getNote(@PathVariable("id") Long id){
        Optional<Note> note = noteService.getNote(id);
        if (note.isPresent()){
            return new ResponseEntity<>(note.get(), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<?> addNewNote(@RequestBody Note newNote){
        Note note = noteService.addNewNote(newNote);
        return new ResponseEntity<>(note, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> updateNote(@PathVariable("id") Long id, @RequestBody Note note){
        Note newNote = noteService.updateNote(id, note);
        if(newNote != null){
            return new ResponseEntity<>(newNote, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteNote(@PathVariable("id") Long id){
        noteService.deleteNote(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
