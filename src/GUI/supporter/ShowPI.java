package GUI.supporter;

import GUI.student.ST_Menu;
import main.MainFunction;
import model.Account;
import model.Person;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

public class ShowPI {
    private JPanel showPI;
    private JLabel nameLabel;
    private JButton backButton;
    private JPanel content;
    private JLabel name;
    private JLabel gen;
    private JLabel handle;
    private JLabel group;

    public ShowPI(JFrame frame, Account account) {
        List<Person> sup;
        try {
            sup= MainFunction.personDAO.findID(account.getId());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        Person me=sup.get(0);
        name.setText("Họ và tên: "+me.getName());
        gen.setText("Khóa: "+me.getGen());
        handle.setText("Handle: "+me.getHandle());
        group.setText("Nhóm: "+me.getGroup());
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(account.getRole().equals("supporter")) {
                    SP_Menu.supporterMenu(frame, account);
                }
                else {
                    ST_Menu.studentMenu(frame, account);
                }
            }
        });
    }
    public static void showPI(JFrame parentFrame, Account account) {
        JFrame frame = new JFrame("Personal Information");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new ShowPI(frame,account).showPI);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        parentFrame.dispose();
    }
}
