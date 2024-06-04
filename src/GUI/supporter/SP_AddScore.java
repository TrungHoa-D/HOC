package GUI.supporter;

import main.MainFunction;
import model.Account;
import model.Person;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

public class SP_AddScore {
    private JPanel addScore;
    private JPanel namePanel;
    private JLabel title;
    private JPanel inputPanel;
    private JTextField textField1;
    private JLabel name1;
    private JLabel name2;
    private JTextField textField2;
    private JButton backButton;
    private JButton submitButton;
    public boolean isInteger(String str) {
        if (str == null) {
            return false;
        }
        return str.matches("-?\\d+");
    }
    public SP_AddScore(JFrame frame, Account account) {
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SP_Menu.supporterMenu(frame,account);
            }
        });
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = textField1.getText();
                Integer score = null;
                if (isInteger(textField2.getText())) {
                    score = Integer.valueOf(textField2.getText());
                }
                else {
                    JOptionPane.showMessageDialog(frame,"Số điểm cộng không hợp lệ vui lòng chỉ nhập số nguyên!");
                    return;
                }
                List<Person> student;
                try {
                    student= MainFunction.personDAO.find(name);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                if (student.isEmpty()) {
                    JOptionPane.showMessageDialog(frame,"Không tìm thấy sinh viên trên!");
                }else {
                    Person selected = student.get(0);
                    if(score!= null){
                        selected.setScore(Math.max(selected.getScore()+score,0));
                        selected.setAvailable_score(Math.max(selected.getScore()+score,0));
                        try {
                            MainFunction.personDAO.update(selected);
                            if(selected.getScore()>0){
                                JOptionPane.showMessageDialog(frame,"Đã cộng "+score+" điểm cho sinh viên "+ selected.getName()+"!");
                            }
                            else {
                                JOptionPane.showMessageDialog(frame,"Đã "+score+" điểm cho sinh viên "+ selected.getName()+"!");
                            }
                            SP_Menu.supporterMenu(frame,account);
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                }
            }
        });
    }
    public static void addScore(JFrame parentFrame, Account account) {
        JFrame frame = new JFrame("Add Score");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new SP_AddScore(frame,account).addScore);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        parentFrame.dispose();
    }
}
