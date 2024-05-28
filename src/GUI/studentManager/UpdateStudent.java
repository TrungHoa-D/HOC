package GUI.studentManager;

import main.MainFunction;
import model.Account;
import model.Person;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

public class UpdateStudent {
    private JPanel updatePanel;
    private JLabel nameLabel;
    private JPanel namePanel;
    private JPanel inputPanel;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JTextField textField7;
    private JTextField textField8;
    private JLabel nameLabel1;
    private JLabel nameLabel2;
    private JLabel nameLabel3;
    private JLabel nameLabel4;
    private JLabel nameLabel5;
    private JLabel nameLabel6;
    private JLabel nameLabel7;
    private JLabel nameLabel8;
    private JButton backButton;
    private JButton updateButton;

    public UpdateStudent(JFrame frame,Account account) {
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StudentManagerMenu.stuManagerMenu(frame, account);
            }
        });
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //System.out.println("updateButton");
                if (textField1.getText().equals("")) {
                    JOptionPane.showMessageDialog(null,"Chưa nhập mã tài khoản!");
                    return;
                }
                Integer id= Integer.parseInt(textField1.getText());
                String name= textField2.getText();
                String gen= textField3.getText();
                String handle= textField4.getText();
                String studentCode= textField5.getText();
                Integer group;
                if (textField6.getText().isEmpty()) {
                    group= null;
                }
                else {
                    group= Integer.parseInt(textField6.getText());
                }
                Integer score;
                if (textField7.getText().isEmpty()) {
                    score= null;
                }
                else {
                    score= Integer.parseInt(textField7.getText());
                }
                String note= textField8.getText();
                List<Person> personList;
                try {
                    personList=MainFunction.personDAO.findID(id);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                Person student= new Person();
                boolean exist=false;
                //System.out.println(id+"*");
                for(Person person:personList) {
                    //System.out.println(account.getId()+" - "+account.getName());
                    if (person.getId().equals(id)) {
                        student = person;
                        exist=true;
                        break;
                    }
                }
                //System.out.println(student);
                if (exist){
                    if(name!= null && !name.isEmpty()) student.setName(name);
                    if(gen!= null && !gen.isEmpty()) student.setGen(gen);
                    if(handle!= null && !handle.isEmpty()) student.setHandle(handle);
                    if(studentCode!= null && !studentCode.isEmpty()) student.setStudentCode(studentCode);
                    if(group!= null) student.setGroup(group);
                    if(score!= null) student.setScore(score);
                    if(note!= null && !note.isEmpty()) student.setNote(note);
                    try {
                        MainFunction.personDAO.update(student);
                        JOptionPane.showMessageDialog(null,"Cập nhật thành công!");
                        StudentManagerMenu.stuManagerMenu(frame, account);
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

    public static void updateStudent(JFrame parentFrame, Account account) {
        JFrame frame = new JFrame("Update Student");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new UpdateStudent(frame,account).updatePanel);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        parentFrame.dispose();
    }
}
