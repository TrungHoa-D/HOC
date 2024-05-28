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

public class DeleteContest {
    private JPanel deleteContest;
    private JPanel removePanel;
    private JLabel nameLabel;
    private JPanel inputPanel;
    private JLabel label;
    private JTextField textField1;
    private JButton removeButton;
    private JButton backButton;

    public DeleteContest(JFrame frame, Account account) {
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ContestMenu.contestMenu(frame,account);
            }
        });
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Contest> contests;
                String name = textField1.getText();
                try {
                    contests= MainFunction.contestDAO.find(name);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                if (contests.size()>0) {
                    try {
                        MainFunction.contestDAO.delete(name);
                        JOptionPane.showMessageDialog(null,"Hủy cuộc thi thành công!");
                        ContestMenu.contestMenu(frame,account);
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                }
                else {
                    JOptionPane.showMessageDialog(null,"Không tìm thấy cuộc thi này!");
                }
            }
        });
    }

    public static void delete(JFrame parentFrame, Account account) {
        JFrame frame = new JFrame("Delete Contest");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new DeleteContest(frame,account).deleteContest);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        parentFrame.dispose();
    }
}
