package org.example.devhw_14.mvc;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class NoteService {

    List<Note> noteList = new ArrayList<>();

    public Note addNote(Note note) {
        noteList.add(note);
        return note;
    }

    public List<Note> listAll() {
        return noteList;
    }

    public void deleteById(long id) {
        for (Note note1 : noteList) {
            if (note1.getId() == id) {
                noteList.remove(note1);
            } else {
                throw new RuntimeException("Id doesnt exist");
            }
        }
    }

    public void update(Note note) {
        for (Note note1 : noteList) {
            if (note1.getId().equals(note.getId())) {
                note1.setTitle("new title");
                note1.setContent("new content");
            } else {
                throw new RuntimeException("Note doesnt exist");
            }
        }
    }

    public Note getById(long id) {
        for (Note note1 : noteList) {
            if (note1.getId() == id) {
                return note1;
            } else {
                throw new RuntimeException("Id doesnt exist");
            }
        }
        return null;
    }

}
