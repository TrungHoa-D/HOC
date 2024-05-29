package GUI.supporter;

import main.MainFunction;
import model.Account;
import model.Contest;
import model.TopContest;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

public class SP_FindContest {
    private JPanel findContest;
    private JPanel showContest;
    private JPanel showCoursePanel;
    private JLabel nameLabel;
    private JButton backButton;
    private JPanel inputPanel;
    private JTextField textField1;
    private JLabel nameInput;
    private JButton findButton;
    private JTable table1;
    private JLabel contestName;

    public SP_FindContest(JFrame frame, Account account) {
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SP_Menu.supporterMenu(frame,account);
            }
        });
        findButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<TopContest> topContests;
                String name=textField1.getText();
                try {
                    topContests= MainFunction.contestDAO.showTop3(name);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                if(topContests.isEmpty()){
                    JOptionPane.showMessageDialog(frame,"Không tìm thấy cuộc thi trên!");
                }
                else {
                    contestName.setText("Kết quả cuộc thi "+name);
                    String[] colNames= {"Họ và tên","Handle","Nhóm","Tổng điểm"};
                    Object[][] data= new Object[topContests.size()][4];
                    for (int i = 0; i < topContests.size(); i++) {
                        data[i][0] = topContests.get(i).getName();
                        data[i][1] = topContests.get(i).getHandle();
                        data[i][2] = topContests.get(i).getGroup();
                        data[i][3] = topContests.get(i).getScore();
                    }
                    DefaultTableModel model = new DefaultTableModel(data,colNames);
                    table1.setEnabled(false);
                    table1.setModel(model);
                    table1.setPreferredScrollableViewportSize(new Dimension(600, 200));
                    TableColumnModel tableColumnModel= table1.getColumnModel();
                    tableColumnModel.getColumn(0).setPreferredWidth(300);
                    tableColumnModel.getColumn(1).setPreferredWidth(200);
                    tableColumnModel.getColumn(2).setPreferredWidth(100);
                    tableColumnModel.getColumn(3).setPreferredWidth(100);
                }

            }
        });
    }
    public static void findContest(JFrame parentFrame, Account account) {
        JFrame frame = new JFrame("Find Contest");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new SP_FindContest(frame,account).findContest);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        parentFrame.dispose();
    }
}
