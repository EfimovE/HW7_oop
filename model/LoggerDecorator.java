package model;

import java.time.LocalDateTime;
import java.util.List;

public class LoggerDecorator implements Repository{
    Repository repository;

    public LoggerDecorator(Repository repository) {
        this.repository = repository;
    }

    @Override
    public List<Note> getAllNotes() {
        System.out.println("все заметки " + LocalDateTime.now());
        return repository.getAllNotes();
    }

    @Override
    public String CreateNote (Note note) {
        System.out.println("создаем заметку " + LocalDateTime.now());
        return repository.CreateNote(note);
    }
    // @Override
    // public String CreateNote(Note note) {

    //     List<Note> notes = getAllNotes();
    //     int max = 0;
    //     for (Note item : notes) {
    //         int id = Integer.parseInt(item.getId());
    //         if (max < id){
    //             max = id;
    //         }
    //     }
    //     int newId = max + 1;
    //     String id = String.format("%d", newId);
    //     note.setId(id);
    //     notes.add(note);
    //     List<String> lines = new ArrayList<>();
    //     for (Note item: notes) {
    //         lines.add(mapper.map(item));
    //     }
    //     fileOperation.saveAllLines(lines);
    //     return id;
    // }

    @Override
    public void NewVersionNote (Note note) {
        System.out.println("обновляем заметку " + LocalDateTime.now());
        repository.NewVersionNote (note);
    }

    @Override
    public void delNoteRepo(String id) {
        System.out.println("все заметки " + LocalDateTime.now());
        repository.delNoteRepo(id);
    }

    // @Override
    // public Note readNote(String id) {
    //     System.out.println("выводим заметку " + LocalDateTime.now());
    //     return storable.readNote(id);
    // }

   
}