package GUI.supporterManager;

import GUI.admin.AdminMenu;
import model.Account;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SupManagerMenu {
    private JPanel supManagerMenuPanel;
    private JLabel nameLabel;
    private JPanel optionPanel;
    private JButton showButton;
    private JButton addButton;
    private JButton updateButton;
    private JButton removeButton;
    private JButton backButton;

    public SupManagerMenu(JFrame frame, Account account) {
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AdminMenu.adminMenu(frame, account);
            }
        });
        showButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ShowSupporter.showSupporter(frame, account);
            }
        });
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddSupporter.addSupporter(frame, account);
            }
        });
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UpdateSupporter.updateSupporter(frame, account);
            }
        });
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RemoveSupporter.removeSupporter(frame, account);
            }
        });
    }
    public static void supporterManagerMenu(JFrame parentFrame, Account account) {
        JFrame frame = new JFrame("Supporter Manager Menu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new SupManagerMenu(frame,account).supManagerMenuPanel);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        parentFrame.dispose();
    }
}
