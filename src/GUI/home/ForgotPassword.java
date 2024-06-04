package GUI.home;

import dao.AccountDAO;
import model.Account;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ForgotPassword {
    private JPanel forgotPasswordPanel;
    private JPanel inputPanel;
    private JPanel namePanel;
    private JLabel nameLabel1;
    private JLabel nameLabel2;
    private JLabel nameLabel3;
    private JLabel nameLabel4;
    private JLabel titleLabel;
    private JPanel inputLabel2;
    private JTextField textField1;
    private JTextField textField2;
    private JPasswordField passwordField1;
    private JPasswordField passwordField2;
    private JButton submitButton;
    private JButton backButton;
    private JLabel statusLabel;

    public ForgotPassword(JFrame frame) {
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Home.home(frame);
            }
        });
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AccountDAO accountDAO = new AccountDAO();
                if (textField1.getText().equals("")) {
                    JOptionPane.showMessageDialog(null,"Chưa nhập id tài khoản!");
                    return;
                }
                Integer id=Integer.parseInt(textField1.getText());
                String name=textField2.getText();
                String password=String.valueOf(passwordField1.getPassword());
                String password2=String.valueOf(passwordField2.getPassword());
                List<Account> list = new ArrayList<>();
                try {
                    list=accountDAO.getAccounts();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                boolean righAcc=false;
                for(Account account:list){
                    if (Objects.equals(account.getId(), id) && account.getName().equals(name)){
                        righAcc=true;
                        break;
                    }
                }
                if (righAcc){
                    boolean repeat=false;
                    System.out.println(password);
                    System.out.println(password2);
                    if (password.equals(password2)) repeat=true;
                    if (!repeat){
                        statusLabel.setText("Mật khẩu không khớp!");
                    }
                    else {
                        try {
                            accountDAO.update(name,password);
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        }
                        statusLabel.setForeground(Color.green);
                        statusLabel.setText("Đổi mật khẩu thành công!");
                    }
                }
                else {
                    statusLabel.setText("Tài khoản không tồn tại!");
                }
            }
        });
    }

    public static void forgot(JFrame parentFrame) {
        JFrame frame = new JFrame("Forgot password");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new ForgotPassword(frame).forgotPasswordPanel);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        parentFrame.dispose();
    }
}
