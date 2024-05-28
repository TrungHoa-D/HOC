package GUI.courseManager;

import GUI.admin.AdminMenu;
import model.Account;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CourseManagerMenu {
    private JPanel CoManagerMenuPanel;
    private JLabel nameLabel;
    private JPanel optionPanel;
    private JButton showButton;
    private JButton addButton;
    private JButton updateButton;
    private JButton removeButton;
    private JButton backButton;

    public CourseManagerMenu(JFrame frame, Account account) {
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AdminMenu.adminMenu(frame, account);
            }
        });
        showButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ShowCourse.showCourse(frame, account);
            }
        });
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddCourse.addCourse(frame, account);
            }
        });
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UpdateCourse.updateCourse(frame, account);
            }
        });
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RemoveCourse.deleteCourse(frame, account);
            }
        });
    }
    public static void courseMenu(JFrame parentFrame, Account account) {
        JFrame frame = new JFrame("Course Manager Menu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new CourseManagerMenu(frame,account).CoManagerMenuPanel);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        parentFrame.dispose();
    }
}
