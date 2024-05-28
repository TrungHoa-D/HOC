package GUI.contestManager;

import GUI.admin.AdminMenu;
import model.Account;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ContestMenu {
    private JPanel contestMenuPanel;
    private JPanel CoManagerMenuPanel;
    private JLabel nameLabel;
    private JPanel optionPanel;
    private JButton showButton;
    private JButton addButton;
    private JButton updateButton;
    private JButton removeButton;
    private JButton backButton;

    public ContestMenu(JFrame frame, Account account) {
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AdminMenu.adminMenu(frame,account);
            }
        });
        showButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ReadContest.readContest(frame,account);
            }
        });
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CreateContest.createContest(frame,account);
            }
        });
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UpdateContest.updateContest(frame,account);
            }
        });
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DeleteContest.delete(frame,account);
            }
        });
    }

    public static void contestMenu(JFrame parentFrame, Account account) {
        JFrame frame = new JFrame("Contest Menu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new ContestMenu(frame,account).contestMenuPanel);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        parentFrame.dispose();
    }
}
