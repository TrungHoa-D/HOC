package GUI.courseManager;

import main.MainFunction;
import model.Account;
import model.Course;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

public class UpdateCourse {
    private JPanel updatePanel;
    private JPanel addCoursePanel;
    private JLabel nameLabel;
    private JPanel namePanel;
    private JLabel nameLabel1;
    private JLabel nameLabel2;
    private JLabel nameLabel3;
    private JLabel nameLabel4;
    private JLabel nameLabel5;
    private JPanel inputPanel;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JButton backButton;
    private JButton submitButton;

    public UpdateCourse(JFrame frame, Account account) {
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CourseManagerMenu.courseMenu(frame, account);
            }
        });
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (textField1.getText().equals("")) {
                    JOptionPane.showMessageDialog(null,"Chưa nhập mã lớp học!");
                    return;
                }
                int id = Integer.parseInt(textField1.getText());
                String name = textField2.getText();
                String content = textField3.getText();
                String date = textField4.getText();
                String place = textField5.getText();
                List<Course> courseList;
                try {
                    courseList= MainFunction.courseDAO.getCourses();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                boolean exists = false;
                Course nowCourse = new Course();
                for (Course course : courseList) {
                    if (course.getId().equals(id)) {
                        nowCourse = course;
                        exists = true;
                        break;
                    }
                }
                if (exists) {
                    if (!name.isEmpty()) { nowCourse.setName(name); }
                    if (!content.isEmpty()) { nowCourse.setContent(content); }
                    if (!date.isEmpty()) {nowCourse.setDay(java.sql.Date.valueOf(date));}
                    if (!place.isEmpty()) {nowCourse.setPlace(place); }
                    try {
                        MainFunction.courseDAO.update(nowCourse);
                        JOptionPane.showMessageDialog(null,"Cập nhật thành công!");
                        CourseManagerMenu.courseMenu(frame,account);
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                }
                else {
                    JOptionPane.showMessageDialog(null,"Lớp học không tồn tại!");
                }
            }
        });
    }
    public static void updateCourse(JFrame parentFrame, Account account) {
        JFrame frame = new JFrame("Update Course");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new UpdateCourse(frame,account).updatePanel);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        parentFrame.dispose();
    }
}
