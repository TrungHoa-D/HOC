package GUI.studentManager;

import main.MainFunction;
import model.Account;
import model.Person;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

public class StudentList {
    private JPanel studentListPanel;
    private JLabel nameLabel;
    private JButton backButton;
    private JTable table1;

    public StudentList(JFrame frame, Account account) {
        List<Person> studentList;
        try {
            studentList= MainFunction.personDAO.getStudents();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        String[] colNames= {"ID","Họ và tên","Khóa","Handle","Mã sinh viên","SĐT","Nhóm","Điểm","Ghi chú"};
        Object[][] data= new Object[studentList.size()][9];
        for (int i = 0; i < studentList.size(); i++) {
            data[i][0] = studentList.get(i).getId();
            data[i][1] = studentList.get(i).getName();
            data[i][2] = studentList.get(i).getGen();
            data[i][3] = studentList.get(i).getHandle();
            data[i][4] = studentList.get(i).getStudentCode();
            data[i][5] = (studentList.get(i).getPhone()!=0) ? "0"+studentList.get(i).getPhone().toString() : "";
            data[i][6] = studentList.get(i).getGroup();
            data[i][7] = studentList.get(i).getScore();
            data[i][8] = studentList.get(i).getNote();
        }
        DefaultTableModel model = new DefaultTableModel(data,colNames);
        table1.setEnabled(false);
        table1.setModel(model);
        table1.setPreferredScrollableViewportSize(new Dimension(1000, 400));
        TableColumnModel tableColumnModel= table1.getColumnModel();
        tableColumnModel.getColumn(0).setPreferredWidth(100);
        tableColumnModel.getColumn(1).setPreferredWidth(500);
        tableColumnModel.getColumn(2).setPreferredWidth(100);
        tableColumnModel.getColumn(3).setPreferredWidth(400);
        tableColumnModel.getColumn(4).setPreferredWidth(400);
        tableColumnModel.getColumn(5).setPreferredWidth(400);
        tableColumnModel.getColumn(6).setPreferredWidth(100);
        tableColumnModel.getColumn(7).setPreferredWidth(100);
        tableColumnModel.getColumn(8).setPreferredWidth(500);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StudentManagerMenu.stuManagerMenu(frame,account);
            }
        });
    }

    public static void studentList(JFrame parentFrame, Account account) {
        JFrame frame = new JFrame("Student list");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new StudentList(frame,account).studentListPanel);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        parentFrame.dispose();
    }
}
