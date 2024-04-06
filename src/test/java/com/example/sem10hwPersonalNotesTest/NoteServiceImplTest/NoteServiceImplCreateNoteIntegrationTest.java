package com.example.sem10hwPersonalNotesTest.NoteServiceImplTest;

import com.example.sem10hwPersonalNotesTest.domain.Note;
import com.example.sem10hwPersonalNotesTest.repository.iNoteRepository;
import com.example.sem10hwPersonalNotesTest.services.iNoteService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

/**
 * Тест проверка на то, что метод CreateNote
 * через сервис iNoteService coздает в репозитории заметку.
 */
@SpringBootTest
public class NoteServiceImplCreateNoteIntegrationTest {

    @MockBean
    public iNoteRepository noteRepository;

    @Autowired
    public iNoteService noteService;
    @Test
    public void testCreateNote() {
        // Arrange
        String title = "first";
        String content = "first";
        Note note = new Note(title, content);
        note.setNoteID(1L);

        // Act
        noteService.createNote(note);

        // Assert
        verify(noteRepository).save(note);
    }
}