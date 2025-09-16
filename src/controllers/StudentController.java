package controllers;

import models.Student;
import models.StudentData;
import views.StudentGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class StudentController {
    public StudentController(StudentData model, StudentGUI view) {
        try {
            model.loadData();
            for (Student student : model.getStudents()) {
                view.addStudent(student);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        view.setAddStudentListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String firstName = view.getFirstName();
                String lastName = view.getLastName();
                String studentID = view.getStudentID();

                if(firstName.isBlank() || lastName.isBlank() || studentID.isBlank()) {
                    view.showError("You must fill out all fields.");
                    return;
                }

                Student student = new Student(firstName, lastName, Integer.parseInt(studentID));
                model.addStudent(student);

                try {
                    model.saveData();
                } catch (IOException ex) {
                    view.showError("Could not save to file.");
                }

                view.addStudent(student);
                view.clearForm();
            }
        });

        view.setRemoveStudentListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Student student = view.getSelectedStudent();

                if(student == null) {
                    view.showError("You must select a student to remove!");
                    return;
                }

                model.removeStudent(student);

                try {
                    model.saveData();
                } catch (IOException ex) {
                    view.showError("Could not save to file.");
                }

                view.removeStudent(student);
            }
        });

        view.setClearListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.clearForm();
            }
        });
    }
}
