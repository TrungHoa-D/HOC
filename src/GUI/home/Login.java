package GUI.home;

import GUI.admin.AdminMenu;
import GUI.student.ST_Menu;
import GUI.supporter.SP_Menu;
import dao.AccountDAO;
import model.Account;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;


public class Login {
    private JPanel loginPanel;
    private JPanel inputPanel;
    private JLabel accountNameLabel;
    private JLabel passwordLabel;
    private JTextField userNameTextField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton forgotButton;
    private JButton backButton;
    private JLabel statusLabel;

    public Login(JFrame parentFrame) {
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Home.home(parentFrame);
            }
        });
        forgotButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ForgotPassword.forgot(parentFrame);
            }
        });
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AccountDAO accountDAO= new AccountDAO();
                String userName = userNameTextField.getText();
                String password = String.valueOf(passwordField.getPassword());
                try {
                    for(Account acc : accountDAO.getAccounts()) {
                        if(acc.getRole().equals("admin") && acc.getName().equals(userName) && acc.getPassword().equals(password)) {
                            AdminMenu.adminMenu(parentFrame,acc);
                            break;
                        }
                        else if(acc.getRole().equals("supporter") && acc.getName().equals(userName) && acc.getPassword().equals(password)) {
                            SP_Menu.supporterMenu(parentFrame,acc);
                            break;
                        }
                        else if(acc.getRole().equals("student") && acc.getName().equals(userName) && acc.getPassword().equals(password)) {
                            ST_Menu.studentMenu(parentFrame,acc);
                            break;
                        }
                        else {
                            statusLabel.setText("Tên đăng nhập hoặc mật khẩu sai!");
                        }
                    }
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }

    public JPanel getLoginPanel() {
        return loginPanel;
    }

    public static void login(JFrame parentFrame) {
        JFrame frame = new JFrame("Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new Login(frame).loginPanel);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        parentFrame.dispose();
    }
}
