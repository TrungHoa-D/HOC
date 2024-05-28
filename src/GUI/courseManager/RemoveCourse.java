package GUI.courseManager;

import GUI.studentManager.StudentManagerMenu;
import main.MainFunction;
import model.Account;
import model.Course;
import model.Person;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

public class RemoveCourse {
    private JPanel removeCoursePanel;
    private JPanel removePanel;
    private JLabel nameLabel;
    private JPanel inputPanel;
    private JLabel label;
    private JTextField textField1;
    private JButton removeButton;
    private JButton backButton;

    public RemoveCourse(JFrame frame, Account account) {
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CourseManagerMenu.courseMenu(frame,account);
            }
        });
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Course> courseList;
                String name = textField1.getText();
                try {
                    courseList= MainFunction.courseDAO.find(name);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                if (courseList.size()>0) {
                    try {
                        MainFunction.courseDAO.delete(name);
                        JOptionPane.showMessageDialog(null,"Hủy lớp học thành công!");
                        CourseManagerMenu.courseMenu(frame,account);
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                }
                else {
                    JOptionPane.showMessageDialog(null,"Không tìm thấy lớp học này!");
                }
            }
        });
    }
    public static void deleteCourse(JFrame parentFrame, Account account) {
        JFrame frame = new JFrame("Delete Course");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new RemoveCourse(frame,account).removeCoursePanel);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        parentFrame.dispose();
    }
}
