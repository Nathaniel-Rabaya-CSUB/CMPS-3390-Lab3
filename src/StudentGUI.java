import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentGUI extends JFrame {
    private JPanel panel1;
    private JList<String> studentList;
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

    public StudentGUI() {
        setContentPane(panel1);
        setSize(500, 500);
        setTitle("Student List");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        DefaultListModel<String> studentListData = new DefaultListModel<>();

        buttonAddStudent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String firstName = inputFirstName.getText();
                String lastName = inputLastName.getText();
                String studentID = inputStudentID.getText();

                if(firstName.isBlank() || lastName.isBlank() || studentID.isBlank()) {
                    return;
                }

                String element = String.format("%s %s (%s)", firstName, lastName, studentID);
                studentListData.addElement(element);
                studentList.setModel(studentListData);

                inputFirstName.setText("");
                inputLastName.setText("");
                inputStudentID.setText("");

                inputFirstName.grabFocus();
            }
        } );

        buttonRemoveStudent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int studentIndex = studentList.getSelectedIndex();

                if(studentIndex < 0) { return; }

                studentListData.remove(studentIndex);
                studentList.setModel(studentListData);
            }
        } );
    }
}
