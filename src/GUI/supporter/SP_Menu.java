package GUI.supporter;

import GUI.admin.AdminMenu;
import GUI.home.Home;
import main.MainFunction;
import model.Account;
import model.Person;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

public class SP_Menu {
    private JPanel SP_MenuPanel;
    private JLabel wellcomeLabel;
    private JLabel nameLabel;
    private JPanel optionPanel;
    private JButton groupMemberButton;
    private JButton classButton;
    private JButton contestButton;
    private JButton addScoreButton;
    private JButton updatePIButton;
    private JButton changePassButton;
    private JButton showPIButton;
    private JButton signOutButton;

    public SP_Menu(JFrame frame, Account account) {
        List<Person> yous = null;
        try {
            yous = MainFunction.personDAO.findID(account.getId());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        Person you=new Person();
        for (Person p : yous) {
            you=p;
            break;
        }
        if (you.getName() == null || you.getName().isEmpty()) {
            wellcomeLabel.setText("Chào mừng hỗ trợ viên "+ account.getName()+ "!");
        } else {
            wellcomeLabel.setText("Chào mừng hỗ trợ viên " + you.getName() + "!");
        }
        signOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Home.home(frame);
            }
        });
    }

    public JPanel getSP_MenuPanel() {
        return SP_MenuPanel;
    }
    public static void supporterMenu(JFrame parentFrame, Account account) {
        JFrame frame = new JFrame("supporter Menu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new SP_Menu(frame,account).getSP_MenuPanel());
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        parentFrame.dispose();
    }
}
