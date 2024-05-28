package GUI.supporterManager;

import main.MainFunction;
import model.Account;
import model.Person;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

public class ShowSupporter {
    private JPanel showManagerPanel;
    private JLabel nameLabel;
    private JButton backButton;
    private JTable table1;

    public ShowSupporter(JFrame frame, Account account) {
        List<Person> supportersList;
        try {
            supportersList= MainFunction.personDAO.getSupporters();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        String[] colNames= {"ID","Họ và tên","Khóa","Handle","Nhóm","Ghi chú"};
        Object[][] data= new Object[supportersList.size()][9];
        for (int i = 0; i < supportersList.size(); i++) {
            data[i][0] = supportersList.get(i).getId();
            data[i][1] = supportersList.get(i).getName();
            data[i][2] = supportersList.get(i).getGen();
            data[i][3] = supportersList.get(i).getHandle();
            data[i][4] = supportersList.get(i).getGroup();
            data[i][5] = supportersList.get(i).getNote();
        }
        DefaultTableModel model = new DefaultTableModel(data,colNames);
        table1.setEnabled(false);
        table1.setModel(model);
        table1.setPreferredScrollableViewportSize(new Dimension(600, 200));
        TableColumnModel tableColumnModel= table1.getColumnModel();
        tableColumnModel.getColumn(0).setPreferredWidth(100);
        tableColumnModel.getColumn(1).setPreferredWidth(300);
        tableColumnModel.getColumn(2).setPreferredWidth(100);
        tableColumnModel.getColumn(3).setPreferredWidth(300);
        tableColumnModel.getColumn(4).setPreferredWidth(100);
        tableColumnModel.getColumn(5).setPreferredWidth(300);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SupManagerMenu.supporterManagerMenu(frame, account);
            }
        });
    }
    public static void showSupporter(JFrame parentFrame, Account account) {
        JFrame frame = new JFrame("Supporters List");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new ShowSupporter(frame,account).showManagerPanel);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        parentFrame.dispose();
    }
}
