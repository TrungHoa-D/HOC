package GUI.student;

import GUI.admin.ChangePass;
import GUI.home.Home;
import GUI.supporter.SP_Menu;
import GUI.supporter.SP_ShowCourse;
import GUI.supporter.ShowPI;
import main.MainFunction;
import model.Account;
import model.Person;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

public class ST_Menu {
    private JPanel St_MenuPanel;
    private JLabel wellcomeLabel;
    private JLabel nameLabel;
    private JPanel optionPanel;
    private JButton classButton;
    private JButton contestButton;
    private JButton updatePIButton;
    private JButton changePassButton;
    private JButton showPIButton;
    private JButton signOutButton;
    private JPanel ST_MenuPanel;

    public ST_Menu(JFrame frame, Account account) {
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
            wellcomeLabel.setText("Chào mừng sinh viên "+ account.getName()+ "!");
        } else {
            wellcomeLabel.setText("Chào mừng sinh viên " + you.getName() + "!");
        }
        signOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Home.home(frame);
            }
        });
        changePassButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ChangePass.changPassword(frame, account);
            }
        });
        showPIButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ShowPI.showPI(frame,account);
            }
        });
        classButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SP_ShowCourse.showMyCourse(frame, account);
            }
        });
        contestButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ST_ShowContestResult.showContestResult(frame, account);
            }
        });
        updatePIButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ST_updatePI.updatePI(frame, account);
            }
        });
    }

    public JPanel getST_MenuPanel() {
        return ST_MenuPanel;
    }
    public static void studentMenu(JFrame parentFrame, Account account) {
        JFrame frame = new JFrame("Student Menu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new ST_Menu(frame,account).getST_MenuPanel());
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        parentFrame.dispose();
    }
}
