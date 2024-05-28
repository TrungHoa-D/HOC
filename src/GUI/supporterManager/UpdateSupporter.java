package GUI.supporterManager;

import GUI.studentManager.StudentManagerMenu;
import main.MainFunction;
import model.Account;
import model.Person;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

public class UpdateSupporter {
    private JPanel updateSupPanel;
    private JPanel updatePanel;
    private JLabel nameLabel;
    private JPanel namePanel;
    private JLabel nameLabel1;
    private JLabel nameLabel2;
    private JLabel nameLabel3;
    private JLabel nameLabel4;
    private JLabel nameLabel5;
    private JLabel nameLabel6;
    private JPanel inputPanel;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField6;
    private JTextField textField8;
    private JButton backButton;
    private JButton updateButton;
    private JTextField textField5;

    public UpdateSupporter(JFrame frame, Account account) {
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SupManagerMenu.supporterManagerMenu(frame, account);
            }
        });
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (textField1.getText().equals("")) {
                    JOptionPane.showMessageDialog(null,"Chưa nhập mã tài khoản!");
                    return;
                }
                Integer id= Integer.parseInt(textField1.getText());
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
                List<Person> personList;
                try {
                    personList= MainFunction.personDAO.findID(id);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                Person supporter= new Person();
                boolean exist=false;
                //System.out.println(id+"*");
                for(Person person:personList) {
                    //System.out.println(account.getId()+" - "+account.getName());
                    if (person.getId().equals(id)) {
                        supporter = person;
                        exist=true;
                        break;
                    }
                }
                //System.out.println(supporter);
                if (exist){
                    if(name!= null && !name.isEmpty()) supporter.setName(name);
                    if(gen!= null && !gen.isEmpty()) supporter.setGen(gen);
                    if(handle!= null && !handle.isEmpty()) supporter.setHandle(handle);
                    if(group!= null) supporter.setGroup(group);
                    if(note!= null && !note.isEmpty()) supporter.setNote(note);
                    try {
                        MainFunction.personDAO.update(supporter);
                        JOptionPane.showMessageDialog(null,"Cập nhật thành công!");
                        SupManagerMenu.supporterManagerMenu(frame, account);
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                }
                else {
                    JOptionPane.showMessageDialog(null,"ID không tồn tại!");
                }
            }
        });
    }
    public static void updateSupporter(JFrame parentFrame, Account account) {
        JFrame frame = new JFrame("Update Supporters");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new UpdateSupporter(frame,account).updateSupPanel);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        parentFrame.dispose();
    }
}
