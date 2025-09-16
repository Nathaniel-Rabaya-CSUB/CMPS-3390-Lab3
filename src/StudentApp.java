import controllers.StudentController;
import models.StudentData;
import views.StudentGUI;

public class StudentApp {
    public static void main(String[] args) {
        StudentGUI view = new StudentGUI();
        StudentData model = new StudentData();
        new StudentController(model, view);

        view.setVisible(true);
    }
}
