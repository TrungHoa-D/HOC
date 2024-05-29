package GUI.admin;

import GUI.student.ST_Menu;
import GUI.supporter.SP_Menu;
import main.MainAccount;
import model.Account;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ChangePass {
    private JPanel changePassPanel;
    private JPanel inputPanel;
    private JPanel namePanel;
    private JLabel nameLabel1;
    private JLabel nameLabel2;
    private JLabel nameLabel3;
    private JPasswordField passwordField1;
    private JPasswordField passwordField2;
    private JPasswordField passwordField3;
    private JButton backButton;
    private JLabel nameLabel;
    private JButton submitButton;

    public ChangePass(JFrame frame, Account account) {
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(account.getRole().equals("admin")){
                    AccManager.accountManager(frame,account);
                }
                else if(account.getRole().equals("supporter")){
                    SP_Menu.supporterMenu(frame,account);
                }
                else {
                    ST_Menu.studentMenu(frame,account);
                }
            }
        });

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nowPass= new String(passwordField1.getPassword());
                String newPass = new String(passwordField2.getPassword());
                String newPass2 = new String(passwordField3.getPassword());
                if(!nowPass.equals(account.getPassword())){
                    JOptionPane.showMessageDialog(null,"Mật khẩu không chính xác!");
                }
                else if(newPass.equals(nowPass)){
                    JOptionPane.showMessageDialog(null,"Mật khẩu mới không được giống mật khẩu cũ!");
                }
                else if(!newPass2.equals(newPass)){
                    JOptionPane.showMessageDialog(null,"Mật khẩu nhập lại không khớp!");
                }
                else {
                    List<Account> list = new ArrayList<Account>();
                    try {
                        MainAccount.accountDAO.update(account.getName(),newPass);
                        list=MainAccount.accountDAO.getAccounts();
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                    JOptionPane.showMessageDialog(null,"Đổi mật khẩu thành công!");
                    Account newAccount=account;
                    for(Account a:list){
                        if(a.getId().equals(account.getId())){
                            newAccount = a;
                            break;
                        }
                    }
                    if(account.getRole().equals("admin")){
                        AccManager.accountManager(frame,newAccount);
                    }
                    else if(account.getRole().equals("supporter")){
                        SP_Menu.supporterMenu(frame,newAccount);
                    }
                    else {
                        ST_Menu.studentMenu(frame,newAccount);
                    }
                }
            }
        });
    }

    public static void changPassword(JFrame parentFrame, Account account) {
        JFrame frame = new JFrame("Change password");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new ChangePass(frame,account).changePassPanel);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        parentFrame.dispose();
    }
}
