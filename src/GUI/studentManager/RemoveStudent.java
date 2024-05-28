package GUI.studentManager;

import main.MainFunction;
import model.Account;
import model.Person;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

public class RemoveStudent {
    private JPanel removePanel;
    private JLabel nameLabel;
    private JPanel inputPanel;
    private JLabel label;
    private JTextField textField1;
    private JButton removeButton;
    private JButton backButton;

    public RemoveStudent(JFrame frame, Account account) {
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StudentManagerMenu.stuManagerMenu(frame, account);
            }
        });
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Person> students;
                String name = textField1.getText();
                try {
                    students= MainFunction.personDAO.find(name);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                if (students.size()>0) {
                    try {
                        MainFunction.personDAO.delete(name);
                        JOptionPane.showMessageDialog(null,"Xóa sinh viên thành công!");
                        StudentManagerMenu.stuManagerMenu(frame, account);
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                }
                else {
                    JOptionPane.showMessageDialog(null,"Không tìm thấy sinh viên này!");
                }
            }
        });
    }

    public static void removeStudent(JFrame parentFrame, Account account) {
        JFrame frame = new JFrame("Remove Student");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new RemoveStudent(frame,account).removePanel);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        parentFrame.dispose();
    }
}
