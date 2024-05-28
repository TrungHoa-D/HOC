package GUI.supporterManager;

import GUI.studentManager.StudentManagerMenu;
import main.MainFunction;
import model.Account;
import model.Person;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AddSupporter {
    private JPanel AddSupporterPanel;
    private JPanel registerPanel;
    private JPanel accPanel;
    private JLabel accLabel1;
    private JLabel accLabel2;
    private JLabel accLabel3;
    private JPanel personPanel;
    private JLabel personLabel1;
    private JLabel personLabel2;
    private JLabel personLabel3;
    private JLabel personLabel4;
    private JLabel titleInput1;
    private JLabel titleInput2;
    private JPanel inputPanel1;
    private JTextField textField1;
    private JTextField textField2;
    private JPasswordField passwordField1;
    private JPanel inputPanel2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JLabel titleLabel;
    private JLabel gapLabel;
    private JButton backButton;
    private JButton submitButton;

    public AddSupporter(JFrame frame, Account account) {
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SupManagerMenu.supporterManagerMenu(frame,account);
            }
        });
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (textField1.getText().equals("")) {
                    JOptionPane.showMessageDialog(null,"Chưa nhập mã tài khoản!");
                    return;
                }
                Integer id= Integer.parseInt(textField1.getText());
                String userName =  textField2.getText();
                String password= String.valueOf(passwordField1.getPassword());
                String name = textField3.getText();
                String gen = textField4.getText();
                String handle=  textField5.getText();
                Integer group = (textField6.getText().isEmpty()) ? 0 : Integer.parseInt(textField6.getText());
                List<Account> accountList= new ArrayList<>();
                try {
                    accountList= MainFunction.accountDAO.getAccounts();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                boolean exist=false;
                //System.out.println(id+"*");
                for(Account account : accountList) {
                    //System.out.println(account.getId()+" - "+account.getName());
                    if (account.getId().equals(id)) {
                        exist=true;
                        break;
                    }
                }
                //System.out.println("exist: "+exist);
                if (exist){
                    JOptionPane.showMessageDialog(null,"ID đã tồn tại!");
                }
                else {
                    Account account= new Account(id,userName,password,"supporter");
                    Person person = new Person(account.getId(),name,gen,handle,"",0,group,0,0,"",account.getId(),0);
                    try {
                        MainFunction.accountDAO.add(account);
                        MainFunction.personDAO.add(person);
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                    JOptionPane.showMessageDialog(null,"Thêm hỗ trợ viên mới thành công!");
                    SupManagerMenu.supporterManagerMenu(frame,account);
                }
            }
        });
    }
    public static void addSupporter(JFrame parentFrame, Account account) {
        JFrame frame = new JFrame("Add Supporters");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new AddSupporter(frame,account).AddSupporterPanel);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        parentFrame.dispose();
    }
}
