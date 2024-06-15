package GUI.supporterManager;

import GUI.studentManager.StudentManagerMenu;
import main.MainFunction;
import model.Account;
import model.Person;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

public class RemoveSupporter {
    private JPanel removeSupPanel;
    private JPanel removePanel;
    private JLabel nameLabel;
    private JPanel inputPanel;
    private JLabel label;
    private JTextField textField1;
    private JButton removeButton;
    private JButton backButton;

    public RemoveSupporter(JFrame frame, Account account) {
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SupManagerMenu.supporterManagerMenu(frame, account);
            }
        });
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Person> supporter;
                List<Account> accounts;
                String name = textField1.getText();
                try {
                    supporter= MainFunction.personDAO.find(name);
                    accounts= MainFunction.accountDAO.getAccounts();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                if (!supporter.isEmpty()) {
                    try {
                        MainFunction.personDAO.delete(name);
                        for (Account a : accounts) {
                            if (a.getId().equals(supporter.get(0).getId())) {
                                MainFunction.accountDAO.delete(a.getName());
                                //System.out.println("removed: "+a.getId());
                            }
                        }
                        JOptionPane.showMessageDialog(null,"Xóa hỗ trợ viên thành công!");
                        SupManagerMenu.supporterManagerMenu(frame, account);
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                }
                else {
                    JOptionPane.showMessageDialog(null,"Không tìm thấy hỗ trợ viên này!");
                }
            }
        });
    }
    public static void removeSupporter(JFrame parentFrame, Account account) {
        JFrame frame = new JFrame("Remove Supporter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new RemoveSupporter(frame,account).removeSupPanel);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        parentFrame.dispose();
    }
}
