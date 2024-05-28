package GUI.contestManager;

import main.MainFunction;
import model.Account;
import model.Contest;
import model.Course;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

public class ReadContest {
    private JPanel showCoursePanel;
    private JLabel nameLebel;
    private JTable table1;
    private JButton backButton;
    private JPanel showContest;

    public ReadContest(JFrame frame, Account account) {
        List<Contest> contestList;
        try {
            contestList= MainFunction.contestDAO.getContests();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        String[] colNames= {"ID","Tên","Mục tiêu","Thể loại","Ngày tổ chức"};
        Object[][] data= new Object[contestList.size()][5];
        for (int i = 0; i < contestList.size(); i++) {
            data[i][0] = contestList.get(i).getId();
            data[i][1] = contestList.get(i).getName();
            data[i][2] = contestList.get(i).getTarget();
            data[i][3] = contestList.get(i).getType();
            data[i][4] = contestList.get(i).getDay();
        }
        DefaultTableModel model = new DefaultTableModel(data,colNames);
        table1.setEnabled(false);
        table1.setModel(model);
        table1.setPreferredScrollableViewportSize(new Dimension(600, 200));
        TableColumnModel tableColumnModel= table1.getColumnModel();
        tableColumnModel.getColumn(0).setPreferredWidth(100);
        tableColumnModel.getColumn(1).setPreferredWidth(200);
        tableColumnModel.getColumn(2).setPreferredWidth(200);
        tableColumnModel.getColumn(3).setPreferredWidth(100);
        tableColumnModel.getColumn(4).setPreferredWidth(100);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ContestMenu.contestMenu(frame,account);
            }
        });
    }
    public static void readContest(JFrame parentFrame, Account account) {
        JFrame frame = new JFrame("Read Contest");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new ReadContest(frame,account).showContest);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        parentFrame.dispose();
    }
}
