package GUI.contestManager;

import GUI.courseManager.CourseManagerMenu;
import main.MainFunction;
import model.Account;
import model.Contest;
import model.Course;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

public class CreateContest {
    private JPanel createContest;
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

    public CreateContest(JFrame frame, Account account) {
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ContestMenu.contestMenu(frame,account);
            }
        });
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (textField1.getText().isEmpty()) {
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
                for (Contest contest : contestList) {
                    if (contest.getId().equals(id)) {
                        exists = true;
                    }
                }
                if (exists) {
                    JOptionPane.showMessageDialog(null,"Mã cuộc thi đã tồn tại!");
                }
                else {
                    Contest contest= new Contest(id,name,target,type,(date.isEmpty())? java.sql.Date.valueOf("2024-05-30") :java.sql.Date.valueOf(date));
                    try {
                        MainFunction.contestDAO.add(contest);
                        JOptionPane.showMessageDialog(null,"Thêm cuộc thi thành công!");
                        ContestMenu.contestMenu(frame,account);
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }
        });
    }

    public static void createContest(JFrame parentFrame, Account account) {
        JFrame frame = new JFrame("Create Contest");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new CreateContest(frame,account).createContest);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        parentFrame.dispose();
    }
}
