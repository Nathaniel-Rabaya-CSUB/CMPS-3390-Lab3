package views;

import models.Student;

import javax.swing.*;
import java.awt.event.ActionListener;

public class StudentGUI extends JFrame {
    private JPanel panel1;
    private JList<Student> studentList;
    private JPanel studentInput;
    private JLabel labelFirstName;
    private JTextField inputFirstName;
    private JLabel labelLastName;
    private JTextField inputLastName;
    private JLabel labelStudentID;
    private JTextField inputStudentID;
    private JPanel studentActions;
    private JButton buttonAddStudent;
    private JButton buttonRemoveStudent;
    private JButton buttonClear;
    private final DefaultListModel<Student> studentListData;

    public StudentGUI() {
        setContentPane(panel1);
        setSize(500, 500);
        setTitle("Student List");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        studentListData = new DefaultListModel<>();
        studentList.setModel(studentListData);
    }

    public String getFirstName() {
        return inputFirstName.getText();
    }

    public String getLastName() {
        return inputLastName.getText();
    }

    public String getStudentID() {
        return inputStudentID.getText();
    }

    public Student getSelectedStudent() {
        return studentList.getSelectedValue();
    }

    public void addStudent(Student student) {
        studentListData.addElement(student);
    }

    public void removeStudent(Student student) {
        studentListData.removeElement(student);
    }

    public void clearForm() {
        inputFirstName.setText("");
        inputLastName.setText("");
        inputStudentID.setText("");
    }

    public void setAddStudentListener(ActionListener listener) {
        buttonAddStudent.addActionListener(listener);
    }

    public void setRemoveStudentListener(ActionListener listener) {
        buttonRemoveStudent.addActionListener(listener);
    }

    public void setClearListener(ActionListener listener) {
        buttonClear.addActionListener(listener);
    }

    public void showError(String error) {
        JOptionPane.showMessageDialog(null, error);
    }
}
