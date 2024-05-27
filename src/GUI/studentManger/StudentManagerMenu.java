package GUI.studentManger;

import GUI.admin.AdminMenu;
import model.Account;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentManagerMenu {
    private JPanel stuManagerMenuPanel;
    private JPanel optionPanel;
    private JButton showButton;
    private JButton addButton;
    private JButton updateButton;
    private JButton removeButton;
    private JButton backButton;
    private JLabel nameLabel;

    public StudentManagerMenu(JFrame frame, Account account) {
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AdminMenu.adminMenu(frame, account);
            }
        });
        showButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StudentList.studentList(frame,account);
            }
        });
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddStudent.addStudent(frame,account);
            }
        });
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UpdateStudent.updateStudent(frame,account);
            }
        });
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RemoveStudent.removeStudent(frame,account);
            }
        });
    }

    public static void stuManagerMenu(JFrame parentFrame, Account account) {
        JFrame frame = new JFrame("Student Manager");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new StudentManagerMenu(frame,account).stuManagerMenuPanel);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        parentFrame.dispose();
    }
}
