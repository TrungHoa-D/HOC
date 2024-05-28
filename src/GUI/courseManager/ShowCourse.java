package GUI.courseManager;

import main.MainFunction;
import model.Account;
import model.Course;
import model.Person;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

public class ShowCourse {
    private JPanel showCoursePanel;
    private JTable table1;
    private JButton backButton;
    private JLabel nameLebel;

    public ShowCourse(JFrame frame, Account account) {
        List<Course> accList;
        try {
            accList= MainFunction.courseDAO.getCourses();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        String[] colNames= {"ID","Tên","Nội dung","Ngày diễn ra","Địa điểm"};
        Object[][] data= new Object[accList.size()][9];
        for (int i = 0; i < accList.size(); i++) {
            data[i][0] = accList.get(i).getId();
            data[i][1] = accList.get(i).getName();
            data[i][2] = accList.get(i).getContent();
            data[i][3] = accList.get(i).getDay();
            data[i][4] = accList.get(i).getPlace();
        }
        DefaultTableModel model = new DefaultTableModel(data,colNames);
        table1.setEnabled(false);
        table1.setModel(model);
        table1.setPreferredScrollableViewportSize(new Dimension(1000, 240));
        TableColumnModel tableColumnModel= table1.getColumnModel();
        tableColumnModel.getColumn(0).setPreferredWidth(100);
        tableColumnModel.getColumn(1).setPreferredWidth(100);
        tableColumnModel.getColumn(2).setPreferredWidth(450);
        tableColumnModel.getColumn(3).setPreferredWidth(100);
        tableColumnModel.getColumn(4).setPreferredWidth(100);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CourseManagerMenu.courseMenu(frame, account);
            }
        });
    }

    public static void showCourse(JFrame parentFrame, Account account) {
        JFrame frame = new JFrame("Course List");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new ShowCourse(frame, account).showCoursePanel);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        parentFrame.dispose();
    }
}
