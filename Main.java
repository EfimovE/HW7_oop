import controllers.UserController;
import model.FileOperation;
import model.FileOperationImpl;
import model.Repository;
import model.RepositoryFile;
import views.ViewUser;
import model.LoggerDecorator;

public class Main {
    public static void main(String[] args) {
        FileOperation fileOperation = new FileOperationImpl("noteBookUser.txt");
        // Repository repository = new RepositoryFile(fileOperation);
        Repository repository = new LoggerDecorator(new RepositoryFile(fileOperation));
        UserController controller = new UserController(repository);

        ViewUser view = new ViewUser(controller);
        view.run();
    }
}