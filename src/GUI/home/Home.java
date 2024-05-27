package GUI.home;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Home {

    private JPanel homePanel;
    private JLabel nameLabel;
    private JButton loginButton;
    private JButton singupButton;
    private JButton forgotButton;
    private JPanel optionPanel;
    private JLabel titleLabel;

    public Home(JFrame parentFrame) {
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Login.login(parentFrame);

            }
        });
        singupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Register.register(parentFrame);
            }
        });
        forgotButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ForgotPassword.forgot(parentFrame);
            }
        });
    }
    public static void home(JFrame previousFrame) {
        JFrame frame = new JFrame("Home");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new Home(frame).homePanel);  // Truyền frame hiện tại vào constructor của Home
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        previousFrame.dispose();
    }
    public static void main(String[] args) {
        home(new JFrame());
    }
}
