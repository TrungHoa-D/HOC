package GUI.admin;

import model.Account;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WatchAcc {
    private JPanel watchAccPanel;
    private JPanel inforPanel;
    private JLabel idLabel;
    private JLabel userNameLabel;
    private JLabel roleLabel;
    private JButton backButton;

    public WatchAcc(JFrame frame, Account account) {
        idLabel.setText("ID: " + account.getId());
        userNameLabel.setText("Tên đăng nhập: "+ account.getName());
        roleLabel.setText("Vai trò: " + account.getRole());
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AccManager.accountManager(frame,account);
            }
        });
    }

    public JPanel getWatchAccPanel() {
        return watchAccPanel;
    }

    public static void watchAccount(JFrame parentFrame, Account account) {
        JFrame frame = new JFrame("Account watching");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new WatchAcc(frame,account).watchAccPanel);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        parentFrame.dispose();
    }
}
