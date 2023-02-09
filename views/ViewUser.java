package views;

import controllers.UserController;
import model.Note;


import java.util.Scanner;

public class ViewUser {

    private UserController userController;

    public ViewUser(UserController userController) {
        this.userController = userController;
    }

    public void run(){
        Commands com = Commands.NONE;

        while (true) {
            String command = prompt("Введите команду (CREATE, READ, DELETE, EXIT, UPDATE): ");
            com = Commands.valueOf(command.toUpperCase());
            if (com == Commands.EXIT) return;
            switch (com) {
                case CREATE:
                    String heading = prompt("Заголовок: ");
                    String textNote = prompt("Текст заметки: ");
                    String date = prompt("Дата записи: ");
                    userController.saveNote(new Note(heading,textNote,date));
                    break;
                case READ:
                    String id = prompt("Заметку под каким номером хотите прочитать: ");
                    try {
                        Note note = userController.readNote(id);
                        System.out.println(note);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    break;


                case UPDATE:
                    System.out.println("Ниже указан список имеющихся заметок: ");
                    userController.viewAllNotes();
                    String id1 = prompt("наберите порядковый номер какую хотите изменить: ");
                    try {
                        Note note = userController.readNote(id1);
                        System.out.println(note);
                        userController.updateNote(note);
                        System.out.println("Заметка отредактирована");

                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case DELETE:
                    System.out.println("Ниже указан список имеющихся заметок: ");
                    userController.viewAllNotes();
                    String id2 = prompt("наберите порядковый номер заметки какую хотите удалить: ");
                    try {
                        userController.deleteNote(id2);
                        System.out.println("Заметка под номером "+id2+" успешно удалена");
                    } catch (Exception e){
                        throw new RuntimeException(e);
                    }
                    break;
                

                    }

            }
        }
    

    public static String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }
}