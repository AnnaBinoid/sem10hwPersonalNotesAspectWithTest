package com.example.sem10hwPersonalNotesTest.NoteServiceImplTest;


import com.example.sem10hwPersonalNotesTest.domain.Note;
import com.example.sem10hwPersonalNotesTest.repository.iNoteRepository;
import com.example.sem10hwPersonalNotesTest.services.impl.NoteServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

/**
 * Unit-тест на корректность метода создания новой записи.
 * Метод возвращает ожидаемую запись и создает её единожды.
 */
@ExtendWith(MockitoExtension.class)
public class NoteServiceImplCreateNoteTest {

    @Mock
    private iNoteRepository noteRepository;

    @InjectMocks
    private NoteServiceImpl noteService;

    @Test
    public void testCreateNote() {
        // Создаем тестовую запись
        Note testNote = new Note(null, null);
        testNote.setNoteID(1L);
        testNote.setNoteName("Test Note");
        testNote.setNoteBody("Test content");

        // Настройка поведения mock-объекта
        when(noteRepository.save(testNote)).thenReturn(testNote);

        // Вызываем тестируемый метод
        Note createdNote = noteService.createNote(testNote);

        // Проверяем, что метод вернул ожидаемую запись

         assertEquals(testNote.getNoteID(), createdNote.getNoteID());
         assertEquals(testNote.getNoteName(), createdNote.getNoteName());
         assertEquals(testNote.getNoteBody(), createdNote.getNoteBody());


    }
}
