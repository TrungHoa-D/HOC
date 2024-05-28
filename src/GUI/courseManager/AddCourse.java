package GUI.courseManager;

import main.MainFunction;
import model.Account;
import model.Course;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

public class AddCourse {
    private JPanel addCoursePanel;
    private JLabel nameLabel;
    private JPanel namePanel;
    private JPanel inputPanel;
    private JLabel nameLabel1;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JButton backButton;
    private JButton submitButton;
    private JLabel nameLabel2;
    private JLabel nameLabel3;
    private JLabel nameLabel4;
    private JLabel nameLabel5;

    public AddCourse(JFrame frame, Account account) {
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CourseManagerMenu.courseMenu(frame,account);
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
                for (Course course : courseList) {
                    if (course.getId().equals(id)) {
                        exists = true;
                    }
                }
                if (exists) {
                    JOptionPane.showMessageDialog(null,"Mã lớp học đã tồn tại!");
                }
                else {
                    Course newCourse= new Course(id,name,content,(date.isEmpty())? java.sql.Date.valueOf("2024-05-30") :java.sql.Date.valueOf(date),place);
                    try {
                        MainFunction.courseDAO.add(newCourse);
                        JOptionPane.showMessageDialog(null,"Thêm lớp học thành công!");
                        CourseManagerMenu.courseMenu(frame,account);
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }
        });
    }
    public static void addCourse(JFrame parentFrame, Account account) {
        JFrame frame = new JFrame("Create Course");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new AddCourse(frame,account).addCoursePanel);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        parentFrame.dispose();
    }
}
