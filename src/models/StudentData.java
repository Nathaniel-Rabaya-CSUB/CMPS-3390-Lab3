package models;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StudentData {
    private final List<Student> students;
    private String fileName;

    public StudentData() {
        fileName = "./student.data";
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudent(Student student) {
        students.remove(student);
    }

    public List<Student> getStudents() {
        return students;
    }

    public void saveData() throws IOException, ClassCastException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName));
        out.writeObject(students);
    }

    public void loadData() throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName));
        List<Student> loaded = (List<Student>) in.readObject();
        students.clear();
        students.addAll(loaded);
    }
}
