package pl.kopka.kursspringboot2.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import pl.kopka.kursspringboot2.Model.Note;
import pl.kopka.kursspringboot2.Repository.NoteRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.BDDMockito.given;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class NoteControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    NoteRepo noteRepo;

    @Test
    void should_get_all_notes() throws Exception {
        //given
        given(noteRepo.findAll()).willReturn(initData());
        //then
        mockMvc.perform(get("/note"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$[0].title").value("Test 1"))
                .andExpect(jsonPath("$[1].title").value("Test 2"));
    }

    @Test
    void should_get_note() throws Exception {
        //given
        Note note = new Note();
        note.setId(1L);
        note.setTitle("Title 1");
        note.setContent("Content 1");
        note.setDate("2020-10-10");

        given(noteRepo.findById(any(Long.class))).willReturn(
                Optional.of(note));
        //then
        mockMvc.perform(get("/note/{id}", note.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(note.getId()))
                .andExpect(jsonPath("$.title").value(note.getTitle()))
                .andExpect(jsonPath("$.content").value(note.getContent()))
                .andExpect(jsonPath("$.date").value(note.getDate()));

    }

    @Test
    void should_add_new_note() throws Exception {
        //given
        Note note = new Note(null, "Title", "Content", "2020-11-09");
        given(noteRepo.save(any(Note.class))).willReturn(new Note(1L, note.getTitle(), note.getContent(), note.getDate()));

        //then
        mockMvc.perform(post("/note")
                .content(asJsonString(note))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.title").value(note.getTitle()))
                .andExpect(jsonPath("$.content").value(note.getContent()))
                .andExpect(jsonPath("$.date").value(note.getDate()));
    }

    @Test
    void should_update_Note() throws Exception {
        //given
        Long id = 1L;
        Note note = new Note(null, "Title", "Content", "2020-10-10");
        given(noteRepo.save(any(Note.class))).willReturn(new Note(id, note.getTitle(), note.getContent(), note.getDate()));
        //then
        mockMvc.perform(put("/note/{id}", id)
                .content(asJsonString(note))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(id))
                .andExpect(jsonPath("$.title").value(note.getTitle()))
                .andExpect(jsonPath("$.content").value(note.getContent()))
                .andExpect(jsonPath("$.date").value(note.getDate()));
    }

    @Test
    void should_delete_note() throws Exception {
        //given
        Long id = 1L;
        //then
        mockMvc.perform(delete("/note/{id}", id) )
                .andExpect(status().isAccepted());
    }


    List<Note> initData() {
        List<Note> notes = new ArrayList<>();
        Note note1 = new Note();
        note1.setId(1L);
        note1.setTitle("Test 1");
        note1.setContent("Content 1");
        note1.setDate("2020-10-10");
        notes.add(note1);

        Note note2 = new Note();
        note2.setId(2L);
        note2.setTitle("Test 2");
        note2.setContent("Content 2");
        note2.setDate("2020-12-12");
        notes.add(note2);
        return notes;
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}