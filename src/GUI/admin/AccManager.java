package GUI.admin;

import GUI.home.Home;
import main.MainAccount;
import model.Account;
import model.Person;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class AccManager {
    private JPanel accManaPanel;
    private JLabel nameLabel;
    private JPanel optionPanel;
    private JButton informationButton;
    private JButton changePassButton;
    private JButton deleteButton;
    private JButton backButton;

    public AccManager(JFrame frame, Account account) {
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AdminMenu.adminMenu(frame, account);
            }
        });
        informationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                WatchAcc.watchAccount(frame,account);
            }
        });
        changePassButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ChangePass.changPassword(frame,account);
            }
        });
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    List<Person> list = MainAccount.personDAO.findID(account.getId());
                    if(!list.isEmpty()){
                        Person person = list.get(0);
                        //System.out.println(person.getName());
                        MainAccount.personDAO.delete(person.getName());
                    }
                    //System.out.println(account.getName());
                    MainAccount.accountDAO.delete(account.getName());
                    JOptionPane.showMessageDialog(null,"Xóa tài khoản thành công!");
                    Home.home(frame);
                }
                catch(Exception ex){
                    JOptionPane.showMessageDialog(frame,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    public JPanel getAccManaPanel() {
        return accManaPanel;
    }

    public static void accountManager(JFrame parentFrame, Account account) {
        JFrame frame = new JFrame("Account Management");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new AccManager(frame,account).getAccManaPanel());
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        parentFrame.dispose();
    }
}
