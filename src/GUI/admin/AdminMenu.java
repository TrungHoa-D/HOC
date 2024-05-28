package GUI.admin;

import GUI.contestManager.ContestMenu;
import GUI.courseManager.CourseManagerMenu;
import GUI.home.Home;
import GUI.studentManager.StudentManagerMenu;
import GUI.supporterManager.SupManagerMenu;
import main.MainFunction;
import model.Account;
import model.Person;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

public class AdminMenu {
    private JPanel menuPanel;
    private JLabel wellcomeLabel;
    private JLabel nameLabel;
    private JPanel optionPanel;
    private JButton accButton;
    private JButton studentButton;
    private JButton supporterButton;
    private JButton classButton;
    private JButton contestButton;
    private JButton signOutButton;

    public AdminMenu(JFrame frame, Account account) {
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
            wellcomeLabel.setText("Chào mừng quản trị viên "+ account.getName()+ "!");
        } else {
            wellcomeLabel.setText("Chào mừng quản trị viên " + you.getName() + "!");
        }
        signOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Home.home(frame);
            }
        });
        accButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AccManager.accountManager(frame,account);
            }
        });
        studentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StudentManagerMenu.stuManagerMenu(frame,account);
            }
        });
        supporterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SupManagerMenu.supporterManagerMenu(frame,account);
            }
        });
        classButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CourseManagerMenu.courseMenu(frame,account);
            }
        });
        contestButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ContestMenu.contestMenu(frame,account);
            }
        });
    }

    public JPanel getMenuPanel() {
        return menuPanel;
    }

    public static void adminMenu(JFrame parentFrame, Account account) {
        JFrame frame = new JFrame("Admin Menu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new AdminMenu(frame,account).menuPanel);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        parentFrame.dispose();
    }
}
