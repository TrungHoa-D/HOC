package GUI.contestManager;

import GUI.courseManager.CourseManagerMenu;
import main.MainFunction;
import model.Account;
import model.Contest;
import model.Course;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

public class UpdateContest {
    private JPanel updateContest;
    private JPanel addCoursePanel;
    private JLabel nameLabel;
    private JPanel namePanel;
    private JLabel nameLabel1;
    private JLabel nameLabel2;
    private JLabel nameLabel3;
    private JLabel nameLabel5;
    private JLabel nameLabel4;
    private JPanel inputPanel;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JButton backButton;
    private JButton submitButton;

    public UpdateContest(JFrame frame, Account account) {
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ContestMenu.contestMenu(frame,account);
            }
        });
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (textField1.getText().equals("")) {
                    JOptionPane.showMessageDialog(null,"Chưa nhập mã cuộc thi!");
                    return;
                }
                int id = Integer.parseInt(textField1.getText());
                String name = textField2.getText();
                String target = textField3.getText();
                String type = textField4.getText();
                String date = textField5.getText();
                List<Contest> contestList;
                try {
                    contestList= MainFunction.contestDAO.getContests();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                boolean exists = false;
                Contest nowContest = new Contest();
                for (Contest contest : contestList) {
                    if (contest.getId().equals(id)) {
                        nowContest=contest;
                        exists = true;
                    }
                }
                if (exists) {
                    if (!name.isEmpty()) { nowContest.setName(name); }
                    if (!target.isEmpty()) { nowContest.setTarget(target); }
                    if (!date.isEmpty()) {nowContest.setDay(java.sql.Date.valueOf(date));}
                    if (!type.isEmpty()) {nowContest.setType(type); }
                    try {
                        MainFunction.contestDAO.update(nowContest);
                        JOptionPane.showMessageDialog(null,"Cập nhật thành công!");
                        ContestMenu.contestMenu(frame,account);
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                }
                else {
                    JOptionPane.showMessageDialog(null,"Cuộc thi không tồn tại!");
                }
            }
        });
    }
    public static void updateContest(JFrame parentFrame, Account account) {
        JFrame frame = new JFrame("Update Contest");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new UpdateContest(frame,account).updateContest);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        parentFrame.dispose();
    }
}
