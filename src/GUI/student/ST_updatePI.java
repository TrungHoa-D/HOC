package GUI.student;

import GUI.supporter.SP_Menu;
import main.MainFunction;
import model.Account;
import model.Person;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

public class ST_updatePI {
    private JPanel updateStudent;
    private JPanel updatePanel;
    private JLabel nameLabel;
    private JPanel namePanel;
    private JLabel nameLabel2;
    private JLabel nameLabel3;
    private JLabel nameLabel4;
    private JLabel nameLabel5;
    private JLabel nameLabel6;
    private JPanel inputPanel;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField6;
    private JTextField textField5;
    private JButton backButton;
    private JButton updateButton;

    public ST_updatePI(JFrame frame, Account account) {
        List<Person> stu;
        try {
            stu= MainFunction.personDAO.findID(account.getId());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        Person me=stu.get(0);
        textField2.setText(me.getName());
        textField3.setText(me.getGen());
        textField4.setText(me.getHandle());
        textField5.setText(me.getGroup().toString());
        textField6.setText(me.getNote());

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ST_Menu.studentMenu(frame,account);
            }
        });


        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name= textField2.getText();
                String gen= textField3.getText();
                String handle= textField4.getText();
                Integer group;
                if (textField5.getText().isEmpty()) {
                    group= null;
                }
                else {
                    group= Integer.parseInt(textField5.getText());
                }
                String note= textField6.getText();
                Person supporter= me;
                if(name!= null && !name.isEmpty()) supporter.setName(name);
                if(gen!= null && !gen.isEmpty()) supporter.setGen(gen);
                if(handle!= null && !handle.isEmpty()) supporter.setHandle(handle);
                if(group!= null) supporter.setGroup(group);
                if(note!= null && !note.isEmpty()) supporter.setNote(note);
                try {
                    MainFunction.personDAO.update(supporter);
                    JOptionPane.showMessageDialog(null,"Cập nhật thành công!");
                    ST_Menu.studentMenu(frame,account);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }
    public static void updatePI(JFrame parentFrame, Account account) {
        JFrame frame = new JFrame("Update Student Information");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new ST_updatePI(frame,account).updateStudent);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        parentFrame.dispose();
    }
}
