package controllers;

import model.*;
import views.ViewUser;

import java.util.ArrayList;
import java.util.List;

public class UserController {

    // public static final String ANSI_RESET = "\u001B[0m";
    // public static final String ANSI_BLUE = "\u001B[34m";
    private final Repository repository;

    public UserController(Repository repository) {
        this.repository = repository;

    }

    public void saveNote(Note note) {
        repository.CreateNote(note);
    }

    public void updateNote(Note note) {
        repository.NewVersionNote(note);
    }

    public void deleteNote(String id) {
        repository.delNoteRepo(id);
    }



    public void viewAllNotes() {
        List<Note> notes = repository.getAllNotes();
        for (Note note : notes) {
            System.out.println(note);
        }
    }


    public Note readNote(String noteId) throws Exception {
        List<Note> notes = repository.getAllNotes();
        for (Note note : notes) {
            if (note.getId().equals(noteId)) {
                return note;
            }
        }

        throw new Exception("User not found");
    }
}